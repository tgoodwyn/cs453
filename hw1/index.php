<?php 
<<<<<<< HEAD
  $occupied = filter_var($_REQUEST["occupied"], FILTER_VALIDATE_BOOLEAN);
  // print "<p>Hi, $mydata! This is new important data for your web page.</p> ";
  if (!$occupied)
  {
    echo "<p>$occupied desk now full.</p> ";
  } else {
    echo "<p>desk already full.</p> ";
  }
=======
  // $occupied    = filter_var($_REQUEST["occupied"], FILTER_VALIDATE_BOOLEAN);
  $occupied    = $_REQUEST["occupied"];
  $StudentOrTeacher  = ($_REQUEST["StudentOrTeacher"]);
  $DeskOrNot   = ($_REQUEST["DeskOrNot"]);
  $EntryOrExit = ($_REQUEST["EntryOrExit"]);


  echo "occupied    = $occupied   \n";
  echo "StudentOrTeacher  = $StudentOrTeacher \n";
  echo "DeskOrNot   = $DeskOrNot  \n";
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
>>>>>>> tb2
  ?>
