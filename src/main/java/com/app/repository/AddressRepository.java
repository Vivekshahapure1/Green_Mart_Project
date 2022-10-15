package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Address;
											//spring data api provides to us
public interface AddressRepository extends JpaRepository<Address, Long> {
													//our entity class , type of primary key
	@Query("select a from Address a where a.user.id=:userId")		//custom HQL query while working with jpa in case of spring boot
	List<Address> getUsersAddress(@Param("userId") long userId);
}
