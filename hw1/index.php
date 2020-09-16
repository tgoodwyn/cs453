<?php 
  $occupied    = $_REQUEST["occupied"];
  $classNum    = $_REQUEST["classNum"];
  $targetRectId    = $_REQUEST["targetRectId"];
  $EntryOrExit    = $_REQUEST["EntryOrExit"];
  $StudentOrTeacher    = $_REQUEST["StudentOrTeacher"];
  $person = $StudentOrTeacher ? "Teacher" : "Student";
  $action = $EntryOrExit ? "exits" : "enters";

  if (($occupied == 0) && $EntryOrExit) {
    print "(No one is there to exit)";
  } else {
    $occupied = $EntryOrExit ? --$occupied : ++$occupied;

    print "Classrom $classNum: $person $action $targetRectId<br />";
    print "# of occupants = $occupied <br />";

    if (($occupied > 1) ) {//|| (($occupied == 1) && !$EntryOrExit)) {
      print "Social distancing alarm: Too many people!<br />";
    }

    if (isset($_REQUEST["DoesWipe"])) {
      $DoesWipe = ($_REQUEST["DoesWipe"]);
      
      if(!$DoesWipe) {
        print "Lysol alarm: Occupant did not wipe desk properly!<br />";
      } 
    }
  
    if (isset($_REQUEST["DoesSanitize"])) {
      $DoesSanitize = ($_REQUEST["DoesSanitize"]);
      
      if(!$DoesSanitize) {
        print "Hand washing station alarm: occupant did not sanitize upon leaving!<br />";
      } 
    }
  }

  if (isset($_REQUEST["IsWearingMask"])) {
    $IsWearingMask = ($_REQUEST["IsWearingMask"]);
    
    if(!$IsWearingMask) {
      print "Mask alarm: Occupant not wearing mask properly!<br />";
    } 
  }




  ?>
