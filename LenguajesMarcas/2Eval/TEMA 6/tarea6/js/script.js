const MAX_DNI_VALUE = 99999999;
const MIN_DNI_VALUE = 0 ;
const DNI_DIVISOR = 23;

window.addEventListener("load" , (e) => {
    let dniNumber = parseInt(prompt("Introduce el número del DNI (solo el número)"));

    (dniNumber >= MIN_DNI_VALUE && dniNumber <= MAX_DNI_VALUE) ? dniNumberIsOnRange(dniNumber) :
        alert("El número proporcionado no es válido");

});

dniNumberIsOnRange =(dniNumber)=>{
    let dniLetterCalculated = calculateDniLetter(dniNumber);
    let userDniLetter = prompt("Introduzca la letra del DNI (solo la letra)");

    if (compareAndValidateLetters(userDniLetter ,dniLetterCalculated)){
        alert("El número y la letra del DNI son correctos");
    }else{
        alert("La letra que ha indicado no es correcta");
    }
};

calculateDniLetter = (dniInput)=>{
    const letters = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F',
        'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

    let  letterIndex = dniInput%DNI_DIVISOR;
    return letters[letterIndex];
};

compareAndValidateLetters = (userLetter , calculatedLetter)=>{
    return userLetter.toLowerCase() === calculatedLetter.toLowerCase();
};
