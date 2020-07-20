package uk.co.perfectscore.app.controllers.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Model object containing the home page week select post.
 */
@Data
public class HomeFormSubmit implements Serializable {

   private static final long serialVersionUID = -4418609396320848855L;

   private String weekNo;
}
