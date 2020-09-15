// Javascript file to control the webpage
classes = [
    class1 = {
        number : 1,
        instructorHasEntered : {data: 0},
        studentInRect1 : {data: 0},
        studentInRect2 : {data: 0},
        studentInRect3 : {data: 0},
        studentInRect4 : {data: 0},
        studentInRect5 : {data: 0},
        studentInRectQ : {data: 0}
    },
    class2 = {
        number : 2,
        instructorHasEntered : {data: 0},
        studentInRect1 : {data: 0},
        studentInRect2 : {data: 0},
        studentInRect3 : {data: 0},
        studentInRect4 : {data: 0},
        studentInRect5 : {data: 0},
        studentInRectQ : {data: 0}
    },
    class3 = {
        number : 3,
        instructorHasEntered : {data: 0},
        studentInRect1 : {data: 0},
        studentInRect2 : {data: 0},
        studentInRect3 : {data: 0},
        studentInRect4 : {data: 0},
        studentInRect5 : {data: 0},
        studentInRectQ : {data: 0}
    }
]


// To do : Link buttons to set these variables
currentStudentWipesUponEntry     = 1;
currentStudentWipesUponExit      = 1;
currentStudentSanitizesUponExit  = 1;
currentStudentIsWearingMask      = 1;
instructorWipesUponEntry         = 1;
instructorWipesUponExit          = 1;
instructorSanitizesUponExit      = 1;
instructorIsWearingMask          = 1;


// This section is for the functions that set the current class
let currentClass = classes[0]

function get_class_index() {
    index = document.getElementById("class-selection").value;
    return index;
}
function class_change() {
    index = get_class_index();
    currentClass = classes[index];
}

// Function that controls boolean for class started or ended
var classStarted = 0;
function setColorUpdateBoolean(btn) {
    var property = document.getElementById(btn);
    // End class
    if (classStarted == 1) {
        property.style.backgroundColor = "#FFFFFF"
        classStarted = 0;        
    }
    // Start classs
    else {
        property.style.backgroundColor = "#7FFF00"
        classStarted = 1;
    }
}



// To do : for each function , include in PHP request the related boolean currentClass variables ( e.g. currentClass. studentInRect1 for studentEnterRect1() )
// To do : for each function , include in PHP request the related boolean currentStudent variables ( e.g. currentStudentWipesUponEntry for studentEnterRect1(), currentStudentSanitizesUponExit for studentExitRect1(), etc. )

// NOTE ON PARAMETER NAMES:
// b_ for boolean value
function sensorCheck(classNum, currentStudent, b_StudentOrTeacher, b_DeskOrNot, b_EntryOrExit) {
    request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4)
            my_callback(currentStudent);
    }
    request.open("GET","index.php?occupied="+currentStudent.data+"&StudentOrTeacher="+b_StudentOrTeacher+"&DeskOrNot="+b_DeskOrNot+"&EntryOrExit="+b_EntryOrExit);
    request.send();
}


// To do: Changed the output to the new consoles need to add the case for which console it needs to output to
function my_callback(toSet) {
    if (request.status == 200) {
      console.log("Request successful ");

      var node = document.createElement("LI");               
      var textnode = document.createTextNode(request.responseText);      
      node.appendChild(textnode);                            
      document.getElementById("consoleClass1").appendChild(node);    
      toSet.data = 1;

    }
    else if (request.status=404) {
      alert("Server was not found: data returned is :\n"+request.responseText);

    }

}