<?php

/* This contains all of the functions that are used by the interface to interact with mysql: the user can't add or delete information, so these are all just accessors to get the location based on the location */


class Location {

      //protected variable for connecting to the database
      protected $db_connect;

      //public function for user connection
	 public function __conn__() {
	 $this->priv_connect();
	 }

	 //Now make the protected function this accesses
protected function priv_connect() {
      //Use the included config file to connect to the database via mysql query
      include "login.php";      
      $this->db_connect = mysql_connect($host,$user,$password) or die("Unable to connect to database");
      mysql_select_db($db,$this->db_connect) or die("There is no such database");
   }

   //We are now connected to the database! Now let's query depending on columns/input
//The first function gets the location based on the street, taking in the street number/name as input

      public function getFromStreet($street_no, $street_name) {
      $query = "SELECT * FROM addresses WHERE street_no=" . $street_no . " AND street_name=" . $street_name;
      $loc = mysql_query($query,__conn__()) OR die("Query did not run");
      return $loc;
     }
}

$inst = new Location();
?>