package com.authentication.application.models;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserViewModel {

	private Long id;
	private String name;
	private String email;
	private String password;
	private List<ProfileViewModel> profiles = new ArrayList<>();


}
