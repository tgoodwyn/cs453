<?php 
  // $occupied    = filter_var($_REQUEST["occupied"], FILTER_VALIDATE_BOOLEAN);
  $occupied    = $_REQUEST["occupied"];
  $StudentOrTeacher  = ($_REQUEST["StudentOrTeacher"]);
  $NoDeskOrYes   = ($_REQUEST["NoDeskOrYes"]);
  $EntryOrExit = ($_REQUEST["EntryOrExit"]);


  echo "occupied    = $occupied   \n";
  echo "StudentOrTeacher  = $StudentOrTeacher \n";
  echo "NoDeskOrYes   = $NoDeskOrYes  \n";
  echo "EntryOrExit = $EntryOrExit\n";
  // print "<p>Hi, $mydata! This is new important data for your web page.</p> ";
  // if (!$occupied && $StudentOrTeacher)
  // {
  //   echo "desk now full";
  //   echo $StudentOrTeacher;
  // } else {
  //   echo "desk already full";
  //   echo $StudentOrTeacher;

  // }
  ?>
