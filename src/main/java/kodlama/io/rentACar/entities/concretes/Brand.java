package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor // parametreli constructor icin
@NoArgsConstructor  // parametresiz constructor icin
@Entity
public class Brand {

	@Id // id primary key'i temsil ediyor
	@GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment(otomatik artan) AI
	@Column(name = "id") // kolon karsiligi
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
}
