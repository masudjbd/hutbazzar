package com.bangla.store.controller;

import com.bangla.store.domain.Category;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bangla.store.domain.Product;
import com.bangla.store.exception.NoProductsFoundUnderCategoryException;
import com.bangla.store.exception.ProductNotFoundException;
import com.bangla.store.service.CategoryService;
import com.bangla.store.service.ProductService;
import com.bangla.store.validator.ProductValidator;
import com.bangla.store.validator.UnitsInStockValidator;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
        @Autowired
	private CategoryService categoryService;

	@Autowired
	private UnitsInStockValidator unitsInStockValidator;

	@Autowired
	private ProductValidator productValidator;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId", "name", "unitPrice",
				"description", "manufacturer",  "unitsInStock",
				"condt", "productImage", "language","category.categoryId");
		binder.setValidator(unitsInStockValidator);
		binder.setValidator(productValidator);
	}

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory) {
		List<Product> products = productService
				.getProductsByCategory(productCategory);

		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("products", products);
		return "products";
	}

	/*
	 * http://localhost:8080/webstore/products/filter/ByCriteria;brand=googl
	 * e,dell;category=tablet,laptop/BySpecification;dimention=10,20,15;colo
	 * r=red,green,blue
	 * 
	 * **
	 * 
	 * @RequestMapping("/filter/{ByCriteria}/{BySpecification}") public String
	 * filter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>>
	 * criteriaFilter, @MatrixVariable(pathVar= " BySpecification")
	 * Map<String,List<String>> specFilter, Model model) {
	 */

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products",
				productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,
			Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
               
                List<Category> categories=categoryService.getList();
//                model.addAttribute("caetgories",categories);
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
        
        @ModelAttribute("categories")
        public List<Category> populateCategory()
        {
            return categoryService.getList();
        }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm( @ModelAttribute("newProduct") @Valid Product newProduct,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory
						+ "\\resources\\images\\" + newProduct.getProductId()
						+ ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
                //newProduct.setCategory(new Category("Laptop", "Lenovo IdeaPad",newProduct));
//                Category cat=new Category();
                        
                 
                        
		 productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,
			ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}

}