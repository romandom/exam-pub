package com.example.demo.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.converter.PersonConvertor;
import com.example.demo.converter.UserConverter;
import com.example.demo.domain.dto.PersonDto;
import com.example.demo.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<PersonDto> getAllUsers()
	{
		return userRepository.findAll().stream().map(PersonConvertor::toDto).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public UserDto getSpecificUser(@PathVariable int id)
	{
		Optional<UserEntity> user = userRepository.findById(id);

		if(!user.isPresent())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " is not present");
		}else
		{
			return UserConverter.toDto(user.get());
		}

	}

}
