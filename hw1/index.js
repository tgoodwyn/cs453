
    class1 = {
        number : 1,
        rectI : {occupied: 0},
        rect1 : {occupied: 0},
        rect2 : {occupied: 0},
        rect3 : {occupied: 0},
        rect4 : {occupied: 0},
        rect5 : {occupied: 0},
        rectQ : {occupied: 0}
    }
    class2 = {
        number : 2,
        rectI : {occupied: 0},
        rect1 : {occupied: 0},
        rect2 : {occupied: 0},
        rect3 : {occupied: 0},
        rect4 : {occupied: 0},
        rect5 : {occupied: 0},
        rectQ : {occupied: 0}
    }
    class3 = {
        number : 3,
        rectI : {occupied: 0},
        rect1 : {occupied: 0},
        rect2 : {occupied: 0},
        rect3 : {occupied: 0},
        rect4 : {occupied: 0},
        rect5 : {occupied: 0},
        rectQ : {occupied: 0}
    }
    
    // To do : Link drop down menu configuration options to set this variable
    currentClass = class1;

    // To do : Link radio button configuration options to set these variables 
    currentStudentWipesUponEntry     = 1;
    currentStudentWipesUponExit      = 1;
    currentStudentSanitizesUponExit  = 1;
    currentStudentIsWearingMask      = 1;
    instructorWipesUponEntry         = 1;
    instructorWipesUponExit          = 1;
    instructorSanitizesUponExit      = 1;
    instructorIsWearingMask          = 1;

    // To do : for each function , include in PHP request the related boolean currentClass variables ( e.g. currentClass. studentInRect1 for studentEnterRect1() )
    // To do : for each function , include in PHP request the related boolean currentStudent variables ( e.g. currentStudentWipesUponEntry for studentEnterRect1(), currentStudentSanitizesUponExit for studentExitRect1(), etc. )

    // NOTE ON PARAMETER NAMES:
    // b_ for boolean value
    // rectID
    // currentRect.occupancy
    function sensorCheck(classNum, currentRect, b_StudentOrTeacher, b_DeskOrNot, b_EntryOrExit) {
        request = new XMLHttpRequest();
        request.onreadystatechange = function () {
          if (request.readyState == 4)
              my_callback(currentRect);
        }
        // The logic pertaining to information that the sensor does not know about is done on the client side 
        // queryDict = {
        // b_EntryOrExit
        // b_StudentOrTeacher
        // b_DeskOrNot 
        // }

        request.open("GET","index.php?occupied="+currentRect.occupied+"&StudentOrTeacher="+b_StudentOrTeacher+"&DeskOrNot="+b_DeskOrNot+"&EntryOrExit="+b_EntryOrExit);
        request.send();
    }

// order of parameters:
// ,b_StudentOrTeacher, b_DeskOrNot, b_EntryOrExit

    document.getElementById ("Enter1").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect1, 0, 0, 0))
    document.getElementById ("Enter2").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect2, 0, 0, 0))
    document.getElementById ("Enter3").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect3, 0, 0, 0))
    document.getElementById ("Enter4").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect4, 0, 0, 0))
    document.getElementById ("Enter5").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect5, 0, 0, 0))
    document.getElementById ("Exit1").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect1, 0, 0, 1))
    document.getElementById ("Exit2").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect2, 0, 0, 1))
    document.getElementById ("Exit3").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect3, 0, 0, 1))
    document.getElementById ("Exit4").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect4, 0, 0, 1))
    document.getElementById ("Exit5").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect5, 0, 0, 1))

// Instructor and question rectangles 
    document.getElementById ("EnterQ").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectQ, 0, 1, 0))
    document.getElementById ("ExitQ").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectQ, 0, 1, 1))
    document.getElementById ("EnterI").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectI, 1, 0, 0))
    document.getElementById ("ExitI").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectI, 1, 0, 1))    
    
// EnterQ
// ExitQ
// EnterI
// ExitI

    function my_callback(toSet) {
        if (request.status == 200) {
          console.log("Request successful ");

          var node = document.createElement("LI");               
          var textnode = document.createTextNode(request.responseText);      
          node.appendChild(textnode);                            
          document.getElementById("myList").appendChild(node);    
          toSet.occupied = 1;

        }
        else if (request.status=404) {
          alert("Server was not found: data returned is :\n"+request.responseText);
    
        }
    
    }
  