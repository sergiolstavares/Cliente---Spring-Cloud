package dio.expertostech.cosmodb.simples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CosmoDbSimplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmoDbSimplesApplication.class, args);
	}
}

@Component
class CosmosMongoExemplo{
	CosmosMongoExemplo(ClienteRepository repository){
		repository.save(new Cliente(null,"Live Dio Experto Tech","74378654367"));
		repository.findAll().forEach(System.out::println);
	}
}
interface ClienteRepository extends MongoRepository<Cliente,String>{}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Cliente{

	@Id
	private String id;
	private String nome;
	private String cpf;
}