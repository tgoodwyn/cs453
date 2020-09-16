<?php 
  $occupied    = $_REQUEST["occupied"];
  $classNum    = $_REQUEST["classNum"];
  $targetRectId    = $_REQUEST["targetRectId"];

  print "occupied    = $occupied  <br /> ";
  print "classNum  = $classNum <br />";
  print "targetRectId   = $targetRectId  <br />";
  // print "EntryOrExit = $EntryOrExit<br />";

  if (isset($_REQUEST["IsWearingMask"])) {
    $IsWearingMask = ($_REQUEST["IsWearingMask"]);
    
    if(!$IsWearingMask) {
      print "Occupant not wearing mask properly!";
    } 
  }
  // $occupied    = filter_var($_REQUEST["occupied"], FILTER_VALIDATE_BOOLEAN);
  // $occupied    = $_REQUEST["occupied"];
  // $StudentOrTeacher  = ($_REQUEST["StudentOrTeacher"]);
  // $NoDeskOrYes   = ($_REQUEST["NoDeskOrYes"]);
  // $EntryOrExit = ($_REQUEST["EntryOrExit"]);
  // $IsWearingMask = ($_REQUEST["IsWearingMask"]);
  // $IsWearingMask = isset($_REQUEST['IsWearingMask']) ? $_REQUEST['IsWearingMask'] : null;

// if (isset(!$IsWearingMask)) {
//     print "Variable IsWearingMask is set to false.<br>";
// } else if (isset($IsWearingMask)) {
//     print "Variable IsWearingMask is set to true.<br>";
// } else {
//     print "Variable IsWearingMask is not set.<br>";
// }
// }
  // $IsWearingMask = ($_REQUEST["IsWearingMask"]);
  
  //   print "Variable IsWearingMask is set.<br>";
  // } else {
    

  // print "occupied    = $occupied   <br />";
  // print "StudentOrTeacher  = $StudentOrTeacher <br />";
  // print "NoDeskOrYes   = $NoDeskOrYes  <br />";
  // print "EntryOrExit = $EntryOrExit<br />";

  ?>
