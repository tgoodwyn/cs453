class1 = {
    number : 1,
    rectI : {occupied: 0,
             id : "Instructor Rectangle"},
    rect1 : {occupied: 0,
             id : "Rectangle 1"},
    rect2 : {occupied: 0,
             id : "Rectangle 2"},
    rect3 : {occupied: 0,
             id : "Rectangle 3"},
    rect4 : {occupied: 0,
             id : "Rectangle 4"},
    rect5 : {occupied: 0,
             id : "Rectangle 5"},
    rectQ : {occupied: 0,
             id : "Question Rectangle"}
}
class2 = {
    number : 2,
    rectI : {occupied: 0,
             id : "Instructor Rectangle"},
    rect1 : {occupied: 0,
             id : "Rectangle 1"},
    rect2 : {occupied: 0,
             id : "Rectangle 2"},
    rect3 : {occupied: 0,
             id : "Rectangle 3"},
    rect4 : {occupied: 0,
             id : "Rectangle 4"},
    rect5 : {occupied: 0,
             id : "Rectangle 5"},
    rectQ : {occupied: 0,
             id : "Question Rectangle"}
}
class3 = {
    number : 3,
    rectI : {occupied: 0,
             id : "Instructor Rectangle"},
    rect1 : {occupied: 0,
             id : "Rectangle 1"},
    rect2 : {occupied: 0,
             id : "Rectangle 2"},
    rect3 : {occupied: 0,
             id : "Rectangle 3"},
    rect4 : {occupied: 0,
             id : "Rectangle 4"},
    rect5 : {occupied: 0,
             id : "Rectangle 5"},
    rectQ : {occupied: 0,
             id : "Question Rectangle"}
}

// To do : Link drop down menu configuration options to set this variable
currentClass = class1;

// To do : Link radio button configuration options to set these variables 
currentStudentWipesUponEntry     = 1;
currentStudentWipesUponExit      = 1;
currentStudentSanitizesUponExit  = 1;
currentStudentIsWearingMask      = 0;
instructorWipesUponEntry         = 1;
instructorWipesUponExit          = 1;
instructorSanitizesUponExit      = 1;
instructorIsWearingMask          = 1;

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
// To do : for each function , include in PHP request the related boolean currentClass variables ( e.g. currentClass. studentInRect1 for studentEnterRect1() )
// To do : for each function , include in PHP request the related boolean currentStudent variables ( e.g. currentStudentWipesUponEntry for studentEnterRect1(), currentStudentSanitizesUponExit for studentExitRect1(), etc. )
// NOTE ON PARAMETER NAMES:
// b_ for boolean value
// rectID
// targetRect.occupancy
function sensorCheck(classNum, targetRect, b_StudentOrTeacher, b_NoDeskOrYes, b_EntryOrExit) {

    request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4)
            my_callback(targetRect);
    }

    // The logic pertaining to information that the sensor does not know about is done on the client side 
    bitField = ""
    let a = [b_StudentOrTeacher, b_NoDeskOrYes, b_EntryOrExit]
    for (let i = 0; i < a.length; i++) {
        bitField += a[i].toString();
    }
  

// +"&classNum="+classNum+"&targetRect="+targetRect.id
    console.log(bitField)
    // bitField = "100"
    request.open("GET","index.php?occupied="+targetRect.occupied+"&classNum="+classNum+"&targetRectId="+targetRect.id+queryDict[bitField]+"&EntryOrExit="+b_EntryOrExit+"&StudentOrTeacher="+b_StudentOrTeacher);
    request.send();
}

// order of parameters:
// ,b_StudentOrTeacher, b_DeskOrNot, b_EntryOrExit

document.getElementById ("Enter1").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect1, 0, 1, 0))
document.getElementById ("Enter2").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect2, 0, 1, 0))
document.getElementById ("Enter3").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect3, 0, 1, 0))
document.getElementById ("Enter4").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect4, 0, 1, 0))
document.getElementById ("Enter5").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect5, 0, 1, 0))
document.getElementById ("Exit1").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect1, 0, 1, 1))
document.getElementById ("Exit2").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect2, 0, 1, 1))
document.getElementById ("Exit3").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect3, 0, 1, 1))
document.getElementById ("Exit4").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect4, 0, 1, 1))
document.getElementById ("Exit5").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rect5, 0, 1, 1))

// Instructor and question rectangles 
document.getElementById ("EnterQ").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectQ, 0, 0, 0))
document.getElementById ("ExitQ").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectQ, 0, 0, 1))
document.getElementById ("EnterI").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectI, 1, 1, 0))
document.getElementById ("ExitI").addEventListener ("click", () => sensorCheck(currentClass.number, currentClass.rectI, 1, 1, 1))    

// EnterQ
// ExitQ
// EnterI
// ExitI

function my_callback(toSet) {
    if (request.status == 200) {
        console.log("Request successful ");

        var node = document.createElement("LI"); 
        var myDiv = document.createElement("div");
        // myDiv.id = 'myDiv';
        myDiv.innerHTML = request.responseText;
        // document.body.appendChild(request.responseText);              
        // var textnode = document.createTextNode(request.responseText);      
        node.appendChild(myDiv);                            
        document.getElementById("myList").appendChild(node);    
        toSet.occupied = 1;

    }
    else if (request.status=404) {
        alert("Server was not found: data returned is :\n"+request.responseText);

    }

}

