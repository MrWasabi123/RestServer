package msp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import msp.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}

