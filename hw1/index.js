// cha cha cha

class1 = {
    number : 1,
    rectI : {
        occupied: 0,
        id : "Instructor Rectangle"
    },
    rect1 : {
        occupied: 0,
        id : "Rectangle 1"
        },
    rect2 : {
        occupied: 0,
        id : "Rectangle 2"
        },
    rect3 : {
        occupied: 0,
        id : "Rectangle 3"
    },
    rect4 : {
        occupied: 0,
        id : "Rectangle 4"
    },
    rect5 : {
        occupied: 0,
        id : "Rectangle 5"
    },
    rectQ : {
        occupied: 0,
        id : "Question Rectangle"
    }
}
class2 = {
    number : 2,
    rectI : {
        occupied: 0,
        id : "Instructor Rectangle"
    },
    rect1 : {
        occupied: 0,
        id : "Rectangle 1"
    },
    rect2 : {
        occupied: 0,
        id : "Rectangle 2"
    },
    rect3 : {
        occupied: 0,
        id : "Rectangle 3"
    },
    rect4 : {
        occupied: 0,
        id : "Rectangle 4"
    },
    rect5 : {
        occupied: 0,
        id : "Rectangle 5"
    },
    rectQ : {
        occupied: 0,
        id : "Question Rectangle"
    }
}
class3 = {
    number : 3,
    rectI : {
        occupied: 0,
        id : "Instructor Rectangle"
    },
    rect1 : {
        occupied: 0,
        id : "Rectangle 1"
    },
    rect2 : {
        occupied: 0,
        id : "Rectangle 2"
    },
    rect3 : {
        occupied: 0,
        id : "Rectangle 3"
    },
    rect4 : {
        occupied: 0,
        id : "Rectangle 4"
    },
    rect5 : {
        occupied: 0,
        id : "Rectangle 5"
    },
    rectQ : {
        occupied: 0,
        id : "Question Rectangle"
    }
}

// To do : Link drop down menu configuration options to set this variable
currentClass = class1;
classStarted = 0;

function get_class_index() {
    index = document.getElementById("class-selection").value;
    return index;
}
function class_change() {
    index = get_class_index();
    switch(index) {
        case "1":
            currentClass = class2;
            break;
        case "2":
            currentClass = class3;
            break;
        default:
            currentClass = class1;
      }
}

// Function for controlling class started boolean
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

// To do : Link radio button configuration options to set these variables 
currentStudentWipesUponEntry     = 0;
instructorWipesUponEntry         = 0;

currentStudentIsWearingMask      = 0;
instructorIsWearingMask          = 0;

currentStudentWipesUponExit      = 0;
currentStudentSanitizesUponExit  = 0;
instructorWipesUponExit          = 0;
instructorSanitizesUponExit      = 0;


function updateBoolean(btn) {
    var property = document.getElementById(btn);

    switch(btn) {

        // Student Enter
        case "EnterMask":
            // End class
            if (currentStudentIsWearingMask == 1) {
                property.style.backgroundColor = "#FFFFFF"
                currentStudentIsWearingMask = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                currentStudentIsWearingMask = 1;
            }
            break;

        case "EnterWipe":
            // End class
            if (currentStudentWipesUponEntry == 1) {
                property.style.backgroundColor = "#FFFFFF"
                currentStudentWipesUponEntry = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                currentStudentWipesUponEntry = 1;
            }
            break;


        // Instructor    
        case "InstMask":
            // End class
            if (instructorIsWearingMask == 1) {
                property.style.backgroundColor = "#FFFFFF"
                instructorIsWearingMask = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                instructorIsWearingMask = 1;
            }
            break;

        case "InstWash":
            // End class
            if (instructorSanitizesUponExit == 1) {
                property.style.backgroundColor = "#FFFFFF"
                instructorSanitizesUponExit = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                instructorSanitizesUponExit = 1;
            }
            break;

        case "InstWipeEntry":
            // End class
            if (instructorWipesUponEntry == 1) {
                property.style.backgroundColor = "#FFFFFF"
                instructorWipesUponEntry = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                instructorWipesUponEntry = 1;
            }
            break;

        case "InstWipeExit":
            // End class
            if (instructorWipesUponExit == 1) {
                property.style.backgroundColor = "#FFFFFF"
                instructorWipesUponExit = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                instructorWipesUponExit = 1;
            }
            break;
        
        // Student Exit

        case "ExitWash":
            // End class
            if (currentStudentSanitizesUponExit == 1) {
                property.style.backgroundColor = "#FFFFFF"
                currentStudentSanitizesUponExit = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                currentStudentSanitizesUponExit = 1;
            }
            break;

        case "ExitWipe":
            // End class
            if (currentStudentWipesUponExit == 1) {
                property.style.backgroundColor = "#FFFFFF"
                currentStudentWipesUponExit = 0;        
            }
            // Start classs
            else {
                property.style.backgroundColor = "#7FFF00"
                currentStudentWipesUponExit = 1;
            }
            break;

        default:
            console.log("Uncaught case")
      }
}




function sensorCheck(classNum, targetRect, b_StudentOrTeacher, b_NoDeskOrYes, b_EntryOrExit) {
    
    queryDict = {

        // Student + Question + Entry 
            "000" :  "&IsWearingMask="+currentStudentIsWearingMask,
        // Student + Question + Exit 
            "001" :  "",
        // Student + Regular + Entry
            "010" :  "&DoesWipe="+currentStudentWipesUponEntry+"&IsWearingMask="+currentStudentIsWearingMask,
        // Student + Regular + Exit
            "011" :  "&DoesWipe="+currentStudentWipesUponExit+"&DoesSanitize="+currentStudentSanitizesUponExit,
        // Teacher + Regular + Entry
            "110" :  "&DoesWipe="+instructorWipesUponEntry+"&IsWearingMask="+instructorIsWearingMask,
        // Teacher + Regular + Exit
            "111" :  "&DoesWipe="+instructorWipesUponExit+"&DoesSanitize="+instructorSanitizesUponExit
        
        }

    request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4)
            my_callback(targetRect, b_EntryOrExit);
    }

    // The logic pertaining to information that the sensor does not know about is done on the client side 
    bitField = ""
    let a = [b_StudentOrTeacher, b_NoDeskOrYes, b_EntryOrExit]
    for (let i = 0; i < a.length; i++) {
        bitField += a[i].toString();
    }
  

    console.log(bitField)
    request.open("GET","index.php?occupied="+targetRect.occupied+"&classNum="+classNum+"&targetRectId="+targetRect.id+queryDict[bitField]+"&EntryOrExit="+b_EntryOrExit+"&StudentOrTeacher="+b_StudentOrTeacher);
    request.send();

    console.log(classStarted)
}

function my_callback(updateRect, action) {
    if (request.status == 200) {
        console.log("Request successful ");

        // UI updates
        var node = document.createElement("LI"); 
        var myDiv = document.createElement("div");
        myDiv.innerHTML = request.responseText;
        node.appendChild(myDiv);     
        
        // Logging to class console
        index = get_class_index();
        switch(index) {
            case "1":
                document.getElementById("consoleClass2").appendChild(node);    
                break;
            case "2":
                document.getElementById("consoleClass3").appendChild(node);    
                break;
            default:
                document.getElementById("consoleClass1").appendChild(node);    
          } 

        // simulation updates
        if (action) {
            if (updateRect.occupied > 0) 
                updateRect.occupied--;
        }
        else
            updateRect.occupied++;



    }
    else if (request.status=404) {
        alert("Server was not found: data returned is :\n"+request.responseText);

    }

}

