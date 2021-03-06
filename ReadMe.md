Notes for the application:

App sent through zip isn't working because I have left out security functionality in the final product by accident. Some have been commented out or forgot to put back in.
Without it, you can't sign in.
Therefore, this is what needs to be added in:

1.)
    Make sure securityConfig.java isn't commented out

2.) User service files need to be fixed because i left out an extends part.
    The extends UserDetailsService is missing from the class and therefore the login won't work.
    password is not encoded in zip so therefore wont work.

Copy code to make sure it works, apologies.

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
  
	
}

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getEmail(), 
				registrationDto.getUsername(),
				passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getAddress()
				,registrationDto.getPayment(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	
	
}
