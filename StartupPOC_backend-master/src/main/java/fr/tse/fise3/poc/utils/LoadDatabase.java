package fr.tse.fise3.poc.utils;

import java.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import fr.tse.fise3.poc.domain.Project;
import fr.tse.fise3.poc.domain.Role;
import fr.tse.fise3.poc.domain.Time;
import fr.tse.fise3.poc.domain.User;
import fr.tse.fise3.poc.repository.ProjectRepository;
import fr.tse.fise3.poc.repository.RoleRepository;
import fr.tse.fise3.poc.repository.TimeRepository;
import fr.tse.fise3.poc.repository.UserRepository;
import fr.tse.fise3.poc.service.ProjectService;
import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
public class LoadDatabase {
	private final PasswordEncoder passwordEncoder;

//	@Bean
//	@Profile("test")
//	CommandLineRunner initTestData(ProjectRepository projectRepository, ProjectService projectService) {
//		return new CommandLineRunner() {
//
//			public void run(String... args) throws Exception {
//                Project prj1 = new Project();
//                prj1.setTitle("Project Start-up POC");
//                prj1.setDescription("Fise 3 Springboot Angular project");
//                projectRepository.save(prj1);  
//			}	
//		};
//	}
//	
	@Bean
	CommandLineRunner initData(ProjectRepository projectRepository, RoleRepository roleRepository,
			UserRepository userRepository, TimeRepository timeRepository) {
		return new CommandLineRunner() {

			public void run(String... args) throws Exception {
               initRoleTable(roleRepository);
               //initUserTable(userRepository);
               //initProjectTable(projectRepository);
               //initTimeTable(timeRepository);
			}	
		};
	}
	
	private void initProjectTable(ProjectRepository projectRepository) {
		Project prj1 = new Project();
        prj1.setTitle("Project Start-up POC");
        prj1.setDescription("Fise 3 Springboot Angular project");
        projectRepository.save(prj1);  
	}
	
	private void initTimeTable(TimeRepository timeRepository) {
		Time time = new Time();
		time.setDateStart(LocalDateTime.now());
		time.setDateEnd(LocalDateTime.now());
		timeRepository.save(time);
	}
	
	private void initUserTable(UserRepository userRepository) {
		User user = new User();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();
		User user6 = new User();
		User user7 = new User();
		
		Role role = new Role();
		
		// Admin
		user.setUsername("paul");
		user.setPassword(passwordEncoder.encode("123"));
		user.setEmail("paul.dupont@gmail.com");
		user.setFirstname("Paul");
		user.setLastname("Dupont");
		user.setEnabled(true);
		role.setId(RoleUtils.ADMIN_ID);
		role.setLabel(RoleUtils.ADMIN_LABEL);
		user.setRole(role);
		user.setCreatedAt(Instant.now());
		userRepository.save(user);
		
		// Manager
		user1.setUsername("marie");
		user1.setPassword(passwordEncoder.encode("123"));
		user1.setEmail("marie.martin@gmail.com");
		user1.setFirstname("Marie");
		user1.setLastname("Martin");
		user1.setEnabled(true);
		role.setId(RoleUtils.MANAGER_ID);
		role.setLabel(RoleUtils.MANAGER_LABEL);
		user1.setRole(role);
		user1.setCreatedAt(Instant.now());
		userRepository.save(user1);
		
		// Employee 1
		user2.setUsername("zou");
		user2.setPassword(passwordEncoder.encode("123"));
		user2.setEmail("zouhair.ghazi@gmail.com");
		user2.setFirstname("Zouhair");
		user2.setLastname("Ghazi");
		user2.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user2.setRole(role);
		user2.setCreatedAt(Instant.now());
		user2.setManager(user1);
		userRepository.save(user2);
		
		// Employee 2
		user3.setUsername("mohamed");
		user3.setPassword(passwordEncoder.encode("123"));
		user3.setEmail("mohamed.lembarek@gmail.com");
		user3.setFirstname("Mohamed");
		user3.setLastname("Lembarki");
		user3.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user3.setRole(role);
		user3.setCreatedAt(Instant.now());
		user3.setManager(user1);
		userRepository.save(user3);
		
		// Employee 3
		user4.setUsername("sophie");
		user4.setPassword(passwordEncoder.encode("123"));
		user4.setEmail("sophie.dubois@gmail.com");
		user4.setFirstname("Sophie");
		user4.setLastname("Dubois");
		user4.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user4.setRole(role);
		user4.setCreatedAt(Instant.now());
		user4.setManager(user1);
		userRepository.save(user4);
		
		// Employee 4
		user5.setUsername("louis");
		user5.setPassword(passwordEncoder.encode("123"));
		user5.setEmail("louis.mendy@gmail.com");
		user5.setFirstname("Louis");
		user5.setLastname("Mendy");
		user5.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user5.setRole(role);
		user5.setCreatedAt(Instant.now());
		user5.setManager(user1);
		userRepository.save(user5);
		
		// Employee 5
		user6.setUsername("quentin");
		user6.setPassword(passwordEncoder.encode("123"));
		user6.setEmail("quentin.rousseau@gmail.com");
		user6.setFirstname("Quentin");
		user6.setLastname("Rousseau");
		user6.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user6.setRole(role);
		user6.setCreatedAt(Instant.now());
		user6.setManager(user1);
		userRepository.save(user6);
		
		// Employee 6
		user7.setUsername("charles");
		user7.setPassword(passwordEncoder.encode("123"));
		user7.setEmail("charles.leclerc@gmail.com");
		user7.setFirstname("Charles");
		user7.setLastname("Leclerc");
		user7.setEnabled(true);
		role.setId(RoleUtils.EMPLOYEE_ID);
		role.setLabel(RoleUtils.EMPLOYEE_LABEL);
		user7.setRole(role);
		user7.setCreatedAt(Instant.now());
		user7.setManager(user1);
		userRepository.save(user7);

		
	}
	
	private void initRoleTable(RoleRepository roleRepository) {
		Role employee = new Role();
		employee.setId(RoleUtils.EMPLOYEE_ID);
		employee.setLabel(RoleUtils.EMPLOYEE_LABEL);
		roleRepository.save(employee);
		
		Role manager = new Role();
		manager.setId(RoleUtils.MANAGER_ID);
		manager.setLabel(RoleUtils.MANAGER_LABEL);
		roleRepository.save(manager);
		
		
		Role admin = new Role();
		admin.setId(RoleUtils.ADMIN_ID);
		admin.setLabel(RoleUtils.ADMIN_LABEL);
		roleRepository.save(admin);
		
	}
	
}