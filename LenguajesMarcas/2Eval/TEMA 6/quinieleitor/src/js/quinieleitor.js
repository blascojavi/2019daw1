import {WIN_LOCAL, TIE, WIN_VISITOR,  tenBets, TOTAL_MATCHS, 
         btnAutoPressed, btnManualPressed,  
        TEN_BETS, hitsByBet} from './values.js'; 

        window.addEventListener("load" , (e)=>{
               generateTenBets();
        });


        btnAutoPressed.addEventListener("click" , ()=>{
               
            calculateResults(TEN_BETS);
        });

        btnManualPressed.addEventListener("click" , ()=>{
            console.log("hiii MANUAL pressed");

        
        });

    
        const ramdomDices = ()=>{
            const MIN = 1 ; 
            const MAX = 10; 
            return Math.floor(Math.random() * (MAX - MIN ) + MIN); 
            
        };

        const generateQuiniela = ()=>{
            let match = 0; 
            let quiniela = {matches : []}; 
            for(match  ; match <= TOTAL_MATCHS ; match ++){
                let winerValue = ramdomDices();
                if(winerValue <= 5 ){
                    quiniela.matches[match] = WIN_LOCAL;  
                }else if(winerValue >=6 && winerValue <= 8){
                    quiniela.matches[match] = TIE; 
                }else if(winerValue >= 9 ){
                    quiniela.matches[match] = WIN_VISITOR; 
                }
            }
            return quiniela;
        }; 

        const generateTenBets=()=>{
            let i = 0
            for(i ; i <= 9 ; i++){
                tenBets.bets[i]= generateQuiniela(); 
            }
        }

        const generateAutoWinnerTicket = ()=>{
            console.log("GENERATING AUTO WINER TICKET ");
            return generateQuiniela();
        };

        const calculateResults = (numOfBets) =>{
            
            let winnerTicket = generateAutoWinnerTicket();
  
        tenBets.bets.forEach((bet , index)=>{
            console.log("apuesta numero: " , index );
            let hits = 0 ;

            bet.matches.forEach((betMatch ,indexMach)=>{
                console.log(winnerTicket.matches[indexMach]);
                console.log(betMatch);
                if(winnerTicket.matches[indexMach] === betMatch){
                    hits++
                    
                }
                hitsByBet[index]=hits;
                
            })

        })
        console.log(hitsByBet);
        }

        //Generar codigo para crear una quiniela 
            ///Para generar por cada partido tirar dados 
                //de 1-5 gana LOcal
                //de 6-8 EMPATE
                //de 9-10 Visitante
        
        //Generar 10 quinielas y guardar en TENBETS

        //Si AUTOMATICO : 

            ///generar una quiniela GANADORA auto y guarda en winTicket

            ///Comparar win con cada una de las 10 ApuestasRandom y calcular ganacias 


        //SI MAANUAL : 
            ///Recoge datos del usuario y guarda en winManualTicket
            ///Comparar win con manual y calcular ganancias 
        



