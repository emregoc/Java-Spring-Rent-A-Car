package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.concretes.BrandManager;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) 
	{
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll()
	{
		//BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());
		// aslinda IoC sayesinde arkada bunun nesnesini olusturur ve ona gore islem yapar,
		// Neden BrandManager Nesnesini olusturur cunku 22. satirda constructor'da,
		// BrandService'yi dependecy injection yaptik ve AutoWired dedik,
		// BrandService'yi implement eden class hangisi BrandManager ondan dolayi,
		// BrandManager'dan instance olusturur
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest)
	{
		this.brandService.add(createBrandRequest);
	}
	
}
