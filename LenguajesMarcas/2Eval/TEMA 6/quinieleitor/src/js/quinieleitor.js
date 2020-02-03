import {WIN_LOCAL, TIE, WIN_VISITOR,  tenBets, TOTAL_MATCHS, 
         btnAutoPressed, btnManualPressed,tableBody,ticketWinner, results,
        TEN_BETS, ONE_BET, hitsByBet, tableResults} from './values.js'; 

        window.addEventListener("load" , (e)=>{
               generateTenBets();
               renderBets();
        });

        btnAutoPressed.addEventListener("click" , ()=>{
            calculateResults(TEN_BETS);
            renderWinnerTicket(generateAutoWinnerTicket());
            renderResults(); 
            
        });

        btnManualPressed.addEventListener("click" , ()=>{
            console.log("hiii MANUAL pressed");
            calculateResults(ONE_BET);

        
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
            return generateQuiniela();
        };

        const calculateResults = (numOfBets) =>{
            let winnerTicket = generateAutoWinnerTicket();
            tenBets.bets.forEach((bet , index)=>{
                let hits = 0 ;
                bet.matches.forEach((betMatch ,indexMach)=>{
                    if(winnerTicket.matches[indexMach] === betMatch){
                        hits++
                        
                    }
                    hitsByBet[index]=hits;
                })
            })

            hitsByBet.forEach(value=>{
                value === 11 ? tableResults.once += 1 : null;
                value === 12 ? tableResults.doce += 1 : null;
                value === 13 ? tableResults.trece += 1 : null;
                value === 14 ? tableResults.catorce += 1 : null;
                value === 15 ? tableResults.quince += 1 : null;
            })
            tableResults.totalWinned = (tableResults.once * 10) + 
                                       (tableResults.doce * 20) + 
                                       (tableResults.trece * 300) + 
                                       (tableResults.catorce * 2400) + 
                                       (tableResults.quince * 120000);
                                       console.log(tableResults.totalWinned);

        }

        const renderBets = ()=>{
            let renderBets = ''; 
            tenBets.bets.forEach((bets , indexBet)=>{
                renderBets += 
                    `<tr>
                        <td>Partido${indexBet+1}</td>`; 
                        
                        bets.matches.forEach((match , indexMatch) =>{
                            renderBets += 
                            `<td> ${match}</td>`
                        })
                       renderBets += `</tr>`
                    })
            tableBody.innerHTML = renderBets;
        }

        const renderWinnerTicket = (winner) =>{
            let winnerHtml = '<tr>'; 
            winner.matches.forEach((match , indexMatch)=>{
                winnerHtml += `<td>Partido${indexMatch+1}</td>`;
            });
            winnerHtml += `</tr><tr>` ;
            winner.matches.forEach((match , indexMatch)=>{
                winnerHtml += `<td>${match}</td>`;
            });
            winnerHtml += `</tr>` ;
            ticketWinner.innerHTML = winnerHtml;
        }; 

        const renderResults= ()=>{

            console.log(tableResults);

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
        



//INVERTIR PARTIDOS APUESTAS , VER VIDEO 
