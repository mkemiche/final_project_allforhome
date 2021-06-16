package io.allforhome;

import io.allforhome.enums.Category;
import io.allforhome.enums.Role;
import io.allforhome.enums.Status;
import io.allforhome.enums.Title;
import io.allforhome.models.*;
import io.allforhome.repositories.ImageUploadRepository;
import io.allforhome.services.CompanyService;
import io.allforhome.services.PropertyService;
import io.allforhome.services.UserService;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class AllforhomeApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(AllforhomeApplication.class, args);
	}


	@Autowired
	UserService userService;

	@Autowired
	CompanyService companyService;

	@Autowired
	ImageUploadRepository imageUploadRepository;

	@Autowired
	PropertyService propertyService;

	@Override
	public void run(String... args) throws Exception {

		Location loc = new Location("123 address","Columbus","43001","OH");
		Location loc2 = new Location("6553 Street One","Pittsburg","42001","PA");
		Location loc3 = new Location("7762 street two","New Albany","43320","OH");


		PrivateUser user1 = new PrivateUser("user1@gmail.com","pass", String.format("%s",Role.ROLE_PRIVATE_USER),"user1");
		PrivateUser user2 = new PrivateUser("user2@gmail.com","pass", String.format("%s",Role.ROLE_PRIVATE_USER),"user2");
		PrivateUser user3 = new PrivateUser("user3@gmail.com","pass", String.format("%s",Role.ROLE_PRIVATE_USER),"user3");
		PrivateUser user4 = new PrivateUser("user4@gmail.com","pass", String.format("%s",Role.ROLE_PRIVATE_USER),"user4");

		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);

		Agent agent1 = new Agent("agent1","pass",String.format("%s",Role.ROLE_AGENT_ADMIN), Title.MR.getTitle(), "marc","daniel");
		Agent agent2 = new Agent("agent2","pass",String.format("%s",Role.ROLE_AGENT_ADMIN), Title.MR.getTitle(), "marc","daniel");
		Agent agent3 = new Agent("agent3","pass",String.format("%s",Role.ROLE_AGENT_ADMIN), Title.MR.getTitle(), "marc","daniel");
		Agent agent4 = new Agent("agent4","pass",String.format("%s",Role.ROLE_AGENT_USER), Title.MR.getTitle(), "marc","daniel");
		Agent agent5 = new Agent("agent5","pass",String.format("%s",Role.ROLE_AGENT_USER), Title.MR.getTitle(), "marc","daniel");
		Agent agent6 = new Agent("agent6","pass",String.format("%s",Role.ROLE_AGENT_USER), Title.MR.getTitle(), "marc","daniel");


		RSAgency company = new RSAgency("AZFY2666276","company name one","6149826776","company1@gmail.com", loc,List.of(agent1));
		RSAgency company2 = new RSAgency("AZFY266682","company name one","6149826776","company2@gmail.com", loc2,List.of(agent2, agent4));
		RSAgency company3 = new RSAgency("AZFY26662897","company name one", "6149826776","company3@gmail.com", loc3,List.of(agent3, agent5, agent6));

		companyService.saveCompany(company);
		companyService.saveCompany(company2);
		companyService.saveCompany(company3);

		userService.saveUser(agent1);
		userService.saveUser(agent2);
		userService.saveUser(agent3);
		userService.saveUser(agent4);
		userService.saveUser(agent5);
		userService.saveUser(agent5);

		Image image = new Image("PJ_REF08872663_6_0.jpg");
		Image image2 = new Image("PJ_REF08872663_6_1.jpg");
		Image image3 = new Image("PJ_REF08872663_6_2.jpg");
		Image image4 = new Image("PJ_REF08872663_6_3.jpg");

		imageUploadRepository.save(image);
		imageUploadRepository.save(image2);
		imageUploadRepository.save(image3);
		imageUploadRepository.save(image4);


		for (int i = 0; i < 20; i++) {
			var property = new Property(Utils.generatePropertyRef(),
					"Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
					"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
					Status.RENT.getValue(), Category.HOUSE.getCategory(), "no type", "1993", "152000", "2000", 3, 4, true, true, true, false, true, false,
					new RegistrationDate(LocalDateTime.now()),
					new Location("123 main street","columbus","43229","OH"), List.of(image, image3, image4));

			propertyService.createProperty(property);

		}



	}
}
