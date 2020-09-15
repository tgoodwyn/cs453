<?php 
  $occupied    = filter_var($_REQUEST["occupied"], FILTER_VALIDATE_BOOLEAN);
  $personType  = ($_REQUEST["StudentOrTeacher"]);
  $DeskOrNot   = ($_REQUEST["DeskOrNot"]);
  $EntryOrExit = ($_REQUEST["EntryOrExit"]);


  echo "occupied    = $occupied   ";
  echo "personType  = $personType ";
  echo "DeskOrNot   = $DeskOrNot  ";
  echo "EntryOrExit = $EntryOrExit";
  // print "<p>Hi, $mydata! This is new important data for your web page.</p> ";
  // if (!$occupied && $personType)
  // {
  //   echo "desk now full";
  //   echo $personType;
  // } else {
  //   echo "desk already full";
  //   echo $personType;

  // }
  ?>
