package com.cs114127134.ecomadmin.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cs114127134.ecomadmin.entity.category;
import com.cs114127134.ecomadmin.entity.company;
import com.cs114127134.ecomadmin.entity.employee;
import com.cs114127134.ecomadmin.entity.product;

import com.cs114127134.ecomadmin.service.companyService;
import com.cs114127134.ecomadmin.service.categoryService;
import com.cs114127134.ecomadmin.service.employeeService;
import com.cs114127134.ecomadmin.service.productService;

@Controller
public class EcomAdminController {
    @Autowired
    private companyService companyService;
    @Autowired
    private categoryService categoryService;
    @Autowired
    private employeeService employeeService;
    @Autowired
    private productService productService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<company> company = companyService.getAllcompanys();
        List<category> category = categoryService.getAllcategorys();
        List<employee> employee = employeeService.getAllemployees();
        List<product> product = productService.getAllproducts();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println(employee);
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        model.addAttribute("company", company);
        model.addAttribute("category", category);
        model.addAttribute("employee", employee);
        model.addAttribute("product", product);

        return "index";
    }


    @GetMapping("/addCompany")
    public String addCompanyForm(Model model, HttpSession session) {
        List<company> company = companyService.getAllcompanys();
        List<Integer> companyIDs = new ArrayList<>();
        for (company c : company) {
            companyIDs.add(c.getCid());
        }

            model.addAttribute("companyIDs", companyIDs);
            return "addCompany";
        /*else {
            session.setAttribute("errorMsg", "ERROR: No company Found!");
            return "redirect:/";
        }*/
        //return "redirect:/";
    }

    @PostMapping("/addCompany")
    public String addNewCompany(@ModelAttribute company newCompany, HttpSession session) {
        companyService.addcompany(newCompany);
        session.setAttribute("successMsg", "Company Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addCategory")
    public String addCategoryForm(Model model, HttpSession session) {
        List<company> companies = companyService.getAllcompanys();
        List<Integer> companyIDs = new ArrayList<>();
        for (company p : companies) {
            companyIDs.add(p.getCid());
        }

        if (companyIDs.size() > 0) {
            model.addAttribute("companyIDs", companyIDs);
            return "addCategory";
        } else {
            session.setAttribute("errorMsg", "ERROR: No Categorys Found!");
            return "redirect:/";
        }
    }

    @PostMapping("/addCategory")
    public String addNewCategory(@ModelAttribute category newCategory, HttpSession session) {
        categoryService.addcategory(newCategory);
        session.setAttribute("successMsg", "Category Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeForm() {
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addNewEmployee(@ModelAttribute employee newEmployee, HttpSession session) {
        employeeService.addemployee(newEmployee);
        session.setAttribute("successMsg", "Employee Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addProduct/{cid}/{caid}")
    public String addProductForm(@PathVariable int cid, @PathVariable int caid, Model model) {
        List<Integer> listOfEid = employeeService.getAllEid();
        int eid = listOfEid.get((new Random()).nextInt(listOfEid.size()));
        model.addAttribute("cid", cid);
        model.addAttribute("caid", caid);
        model.addAttribute("eid", eid);
        return "addProduct";
    }

    @PostMapping("/addProduct/{caid}")
    public String addNewProduct(@PathVariable int caid, @ModelAttribute product newProduct, HttpSession session) {
        productService.addproduct(newProduct);
        session.setAttribute("successMsg", "Product Added Successfully!");
        return "redirect:/Category/" + Integer.toString(caid);
    }

    @GetMapping("/editcompany/{id}")
    public String editcompany(@PathVariable int id, Model model) {
        company returnedcompany = companyService.getcompanyById(id);
        model.addAttribute("returnedcompany", returnedcompany);
        return "editcompany";
    }

    @GetMapping("/editCompany/{id}")
    public String editCompany(@PathVariable int id, Model model) {
        List<company> company = companyService.getAllcompanys();
        List<Integer> companyIDs = new ArrayList<>();
        for (company c : company) {
            companyIDs.add(c.getCid());
        }
        company returnedCompany = companyService.getcompanyById(id);

        model.addAttribute("returnedCompany", returnedCompany);
        model.addAttribute("companyIDs", companyIDs);

        return "editCompany";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        List<company> companies = companyService.getAllcompanys();
        List<Integer> companyIDs = new ArrayList<>();
        for (company p : companies) {
            companyIDs.add(p.getCid());
        }
        category returnedCategory = categoryService.getcategoryById(id);

        model.addAttribute("companyIDs", companyIDs);
        model.addAttribute("returnedCategory", returnedCategory);

        return "editCategory";
    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable int id, Model model) {
        employee returnedEmployee = employeeService.getemployeeById(id);
        model.addAttribute("returnedEmployee", returnedEmployee);
        return "editEmployee";
    }

    @GetMapping("/editProduct/{id}/{caid}")
    public String editProduct(@PathVariable int id, @PathVariable int caid, Model model) {
        product returnedProduct = productService.getproductById(id);
        model.addAttribute("returnedProduct", returnedProduct);
        model.addAttribute("caid", caid);
        return "editProduct";
    }

    @PostMapping("/updatecompany/{caid}")
    public String updatecompany(@PathVariable int caid, @ModelAttribute company updatedcompany,
            HttpSession session) {
        companyService.addcompany(updatedcompany);
        session.setAttribute("successMsg", "Company Updated Successfully!");
        return "redirect:/Category/" + Integer.toString(caid);
    }

    @PostMapping("/updateCompany")
    public String updateCompany(@ModelAttribute company updatedCompany, HttpSession session) {
        companyService.addcompany(updatedCompany);
        session.setAttribute("successMsg", "Company Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute category updatedCategory, HttpSession session) {
        categoryService.addcategory(updatedCategory);
        session.setAttribute("successMsg", "Category Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute employee updatedEmployee,
            HttpSession session) {
        employeeService.addemployee(updatedEmployee);
        session.setAttribute("successMsg", "Employee Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateProduct/{caid}")
    public String updateProduct(@PathVariable int caid, @ModelAttribute product updatedProduct,
            HttpSession session) {
        productService.addproduct(updatedProduct);
        session.setAttribute("successMsg", "Product Updated Successfully!");
        return "redirect:/Category/" + Integer.toString(caid);
    }

    @GetMapping("/deletecompany/{id}")
    public String deletecompany(@PathVariable int id, HttpSession session) {
        if (companyService.getAllcompanysByCid(id).size() == 0) {
            companyService.deletecompany(id);
            session.setAttribute("warningMsg", "company Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Company Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id, HttpSession session) {
        if (categoryService.getAllcategorysByCaid(id).size() == 0 &&
                productService.getproductByPid(id).size() == 0) {
            companyService.deletecompany(id);
            session.setAttribute("warningMsg", "Company Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Company Manager / Product Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, HttpSession session) {
        categoryService.deletecategory(id);
        session.setAttribute("successMsg", "Category Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id, HttpSession session) {
        if (productService.getproductByPid(id).size() == 0) {
            employeeService.deleteemployee(id);
            session.setAttribute("warningMsg", "Employee Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Product Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/completeProduct/{id}/{eid}")
    public String completeProduct(@PathVariable int id, @PathVariable int eid, HttpSession session) {
        productService.deleteproduct(id);
        session.setAttribute("successMsg", "Product Completed!");
        return "redirect:/Employee/" + Integer.toString(eid);
    }

    @GetMapping("/deleteProduct/{id}/{caid}")
    public String deleteProduct(@PathVariable int id, @PathVariable int caid, HttpSession session) {
        productService.deleteproduct(id);
        session.setAttribute("successMsg", "Product Deleted Successfully!");
        return "redirect:/Category/" + Integer.toString(caid);
    }

    @GetMapping("/reassignProduct/{id}/{eid}")
    public String reassignProduct(@PathVariable int id, @PathVariable int eid, HttpSession session) {
        List<Integer> listOfeid = employeeService.getAllEid();
        Random rand = new Random();

        if (listOfeid.size() > 1) {
            int updatedEid = listOfeid.get(rand.nextInt(listOfeid.size()));
            while (updatedEid == eid) {
                updatedEid = listOfeid.get(rand.nextInt(listOfeid.size()));
            }
            productService.updateproductEidByPid(id, updatedEid);
            session.setAttribute("successMsg", "Product Passed Successfully to " + updatedEid + "!");
        } else
            session.setAttribute("errorMsg", "ERROR: Not enough employees to reassign!");

        return "redirect:/Employee/" + Integer.toString(eid);
    }

    @GetMapping("/Employee/{id}")
    public String EmployeePage(@PathVariable int id, HttpSession session, Model model) {
        employee EmployeeDetails = employeeService.getemployeeById(id);
        if (EmployeeDetails == null)
            return "redirect:/";
        List<product> ProductsAssignedToEmployee = productService.getproductByEid(id);
        model.addAttribute("EmployeeDetails", EmployeeDetails);
        model.addAttribute("productsAssignedToEmployee", ProductsAssignedToEmployee);
        return "Employee";
    }

    @GetMapping("/Category/{id}")
    public String CategoryPage(@PathVariable int id, HttpSession session, Model model) {
        category CategoryDetails = categoryService.getcategoryById(id);
        if (CategoryDetails == null)
            return "redirect:/";
        List<product> ProductsUnderThatCompany = productService.getproductByCid(CategoryDetails.getCid());
        model.addAttribute("categoryDetails", CategoryDetails);
        model.addAttribute("productsUnderThatCompany", ProductsUnderThatCompany);
        return "Category";
    }
}