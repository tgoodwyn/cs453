<?php 
  $occupied = $_REQUEST["occupied"];
  // print "<p>Hi, $mydata! This is new important data for your web page.</p> ";
  if ($occupied)
  {
    echo "<p>$occupied desk now full.</p> ";
  } else {
    echo "<p>desk already full.</p> ";
  }
  ?>
