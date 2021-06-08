package io.allforhome;

import io.allforhome.enums.Role;
import io.allforhome.enums.Title;
import io.allforhome.models.*;
import io.allforhome.repositories.ImageUploadRepository;
import io.allforhome.services.CompanyService;
import io.allforhome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	@Override
	public void run(String... args) throws Exception {

		Location loc = new Location("123 address","Columbus",43001,"OH");
		Location loc2 = new Location("6553 Street One","Pittsburg",42001,"PA");
		Location loc3 = new Location("7762 street two","New Albany",43320,"OH");


		PrivateUser user1 = PrivateUser.builder().email("user1@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_PRIVATE_USER)).username("user1").build();
		PrivateUser user2 = PrivateUser.builder().email("user1@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_PRIVATE_USER)).username("user1").build();
		PrivateUser user3 = PrivateUser.builder().email("user1@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_PRIVATE_USER)).username("user1").build();
		PrivateUser user4 = PrivateUser.builder().email("user1@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_PRIVATE_USER)).username("user1").build();

		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);

		Agent agent1 = Agent.builder().email("agent1@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MR.getTitle()).agentFirstName("marc").agentLastName("daniel").build();
		Agent agent2 = Agent.builder().email("agent2@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MS.getTitle()).agentFirstName("Stephanie").agentLastName("dupond").build();
		Agent agent3 = Agent.builder().email("agent3@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MR.getTitle()).agentFirstName("Robert").agentLastName("call").build();
		Agent agent4 = Agent.builder().email("agent4@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MR.getTitle()).agentFirstName("Ted").agentLastName("Foster").build();
		Agent agent5 = Agent.builder().email("agent5@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MS.getTitle()).agentFirstName("Bithany").agentLastName("daniel").build();
		Agent agent6 = Agent.builder().email("agent6@gmail.com").password("pass").roles(String.format("%s",Role.ROLE_AGENT_ADMIN)).title(Title.MS.getTitle()).agentFirstName("Giselle").agentLastName("Scott").build();



		RSAgency company = new RSAgency("AZFY2666276","company name one","6149826776", loc,List.of(agent1));
		RSAgency company2 = new RSAgency("AZFY266682","company name one","6149826776",loc2,List.of(agent2, agent4));
		RSAgency company3 = new RSAgency("AZFY26662897","company name one", "6149826776",loc3,List.of(agent3, agent5, agent6));

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




	}
}
