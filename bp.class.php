<?php

/* This contains all of the functions that are used by the interface to interact with mysql: the user can't add or delete information, so these are all just accessors to get the location based on the location */



class Location {

protected $db_connect;

public function __conn() {
}

//The first function gets the location based on the street, taking in the street number/name as input

public function getFromStreet($street_no, $street_name) {

       include "login.php";		

      //Use the included config file to connect to the database via mysql query
      $this->db_connect = mysql_connect($host,$user,$password) or die("Unable to connect to database");
      mysql_select_db($db,$this->db_connect) or die("There is no such database");
   //We are now connected to the database! Now let's query depending on columns/input

      $query = "SELECT * FROM addresses WHERE street_no='" . $street_no . "' AND street_name='" . $street_name . "'";
      $loc = mysql_query($query,$this->db_connect) OR die("Query did not run");
      
      while ($row = mysql_fetch_array($loc)) {
      $addr = (string)$row['street_no'] . " " . $row['street_name'];
      $addr2 = $row['town_name'] . ", MA " . (string)$row['zip'];
      $coords = $row['latitude'] . ":" . $row['longitude'];
      $id = $row['id'];

      $out = $id . ":" . $addr . ":" . $addr2 . ":" . $coords;
      }    
      return $out;

     }


//This function takes in a user rating, and adds it into ratings via an average
public function getAvg($user_rating, $id) {

       include "login.php";		

      //Use the included config file to connect to the database via mysql query
      $this->db_connect = mysql_connect($host,$user,$password) or die("Unable to connect to database");
      mysql_select_db($db,$this->db_connect) or die("There is no such database");
   //We are now connected to the database! Now let's query depending on columns/input


       $query = "SELECT * FROM ratings WHERE id ='" . $id . "'";
       $num_rates = mysql_query($query,$this->db_connect) or die("Query did not run");

       while ($row = mysql_fetch_array($num_rates)) {
       $orig_num = $row['num_rates'];
       $pre_ratings = $row['rating'];
       }      
              

       $avg_ratings = (($pre_ratings * $orig_num) + $user_rating) / ($orig_num + 1);
       
       $insert_query = "UPDATE ratings SET num_rates='" . ($orig_num+1) . "' WHERE id='" . $id . "'";
       $insert_try = mysql_query($query,$this->db_connect) or die ("Could not insert");

       $insert_query_2 = "UPDATE ratings SET rating=" . $avg_ratings . " WHERE id=" . $id;

       $insert_try2 = mysql_query($query,$this->db_connect) or die ("Could not insert");

       return ($orig_num+1);

       }



//This function just returns the current rating
public function getRating($id) {

       include "login.php";		

      //Use the included config file to connect to the database via mysql query
      $this->db_connect = mysql_connect($host,$user,$password) or die("Unable to connect to database");
      mysql_select_db($db,$this->db_connect) or die("There is no such database");
   //We are now connected to the database! Now let's query depending on columns/input


       $query = "SELECT rating FROM ratings WHERE id ='" . $id . "'";
       $num_rates = mysql_query($query,$this->db_connect) or die("Query did not run");

       while ($row = mysql_fetch_array($num_rates)) {
              $rating = $row['rating'];
       }     

       return $rating;
}       

}





$inst = new Location();
?>