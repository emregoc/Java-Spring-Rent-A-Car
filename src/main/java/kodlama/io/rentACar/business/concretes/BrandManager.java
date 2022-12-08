package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
		// is kurallari
		
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse(); // instance olusturduk
			responseItem.setId(brand.getId()); // yukarda cektigimiz her datanin getId ile idsini,
			responseItem.setName(brand.getName());//alip yukarda olusturdugumuz response List'ine attik.
			
			brandsResponse.add(responseItem); // listeye degerleri ekledik
		}
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand brand = new Brand(); // veritabani Brand istedigi icin Brand tipinde gonderdik
		brand.setName(createBrandRequest.getName());
		
		this.brandRepository.save(brand);
		
	}

}
