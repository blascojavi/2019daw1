 document.addEventListener('load' , init()); 

 function init(){
 
    let duracionPartido = calculaTiempoPartido(); 
    pintar(duracionPartido);
 }

 function calculaTiempoPartido(){
    return tiempoTotalPartido =  aleatorio(0,9) + 90; 
 }


 function aleatorio(min,max){
    if(nim = 0 ){
        max;
        return Math.round((Math.random() * max)) ;
    }else{       
        return Math.round((Math.random() * max) + min) ; 
    }
 }

 function evaluaSubEvento(){
    let subEvento = '';
    let subSuceso = aleatorio(0,99);
    subEvento = (subSuceso >= 0 && subSuceso <= 9 ) ? ' Pal dret':
        subEvento = (subSuceso >= 10 && subSuceso <= 19 ) ? ' Pal esquerre':
         subEvento = (subSuceso >= 20 && subSuceso <= 49 ) ? ' Salva el porter':
          subEvento = (subSuceso >= 50 && subSuceso <= 99 ) ? ' Pal dret':'';
    
    return subEvento; 
 }





function eventSuccess(){
    let suceso = aleatorio(0,99); 
    let evento = "default"; 
    evento = (suceso >= 0 && suceso <= 68) ? 'No Pasa res' : 
     evento = (suceso >= 69 && suceso <= 74) ? 'Accio perillosa local' + subEvento(100) : 
      evento = (suceso >= 75 && suceso <= 79) ? 'Accio perillosa visitant'+ subEvento(100) : 
       evento = (suceso >= 80 && suceso <= 82) ? 'Corner Local' + subEvento(50): 
        evento = (suceso >= 83 && suceso <= 85) ? 'Corner Visitant' + subEvento(50) : 
         evento = (suceso >= 86 && suceso <= 90) ? 'Targeta groga Local' : 
          evento = (suceso >= 91 && suceso <= 95) ? 'Targeta groga Visitant' : 
           evento = (suceso >= 96 && suceso <= 99) ? 'Treta de banda' : '';

console.log('suceso :', suceso);
console.log('evento :', evento);
    
    return evento; 


    function subEvento(probabilidad){

        if(probabilidad == 100 ){
           subEvento = evaluaSubEvento();
        }
        if(probabilidad == 50 && aleatorio(1,100) <= 50){
            subEvento = evaluaSubEvento();
        }else{
            subEvento = '';
        }
    
         return subEvento; 
     }
}


function pintar(duracionPartido){
    console.log('duracionPartido :', duracionPartido);
    const NO_PASA_RES = 'No Pasa res';
   document.write('<table><thead><td>MINUTO</td><td>RESUMEN</td></thead>');
   for(let i = 0 ; i <= duracionPartido ; i++ ){
       let evento = eventSuccess(); 
        evento = (evento == NO_PASA_RES) ? '': evento;
        document.write(`<tr><td>${i}</td><td>${evento}</td></tr>`);
        
   }
   document.write('</table>')


}

