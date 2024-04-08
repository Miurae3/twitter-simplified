package com.miura.twittersimplified.repository;

import com.miura.twittersimplified.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository <Tweet, Long> {


}
