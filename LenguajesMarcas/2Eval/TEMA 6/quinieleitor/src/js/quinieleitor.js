import {WIN_LOCAL, TIE, WIN_VISITOR,  tenBets, TOTAL_MATCHS, 
         btnAutoPressed, btnManualPressed,tableBody,ticketWinner, results,
        TEN_BETS, ELEVEN_BETS, hitsByBet, tableResults, tableManualEleven, manualForm} from './values.js'; 

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
            renderManualForm();

        
        });

        manualForm.addEventListener("submit" , (event)=>{
            event.preventDefault();
            let quinielaManual = {};
            let resultado ; 
            let i = 1 ; 

            for(i ; i<=15 ; i++){
                let partido = document.getElementsByName(`partido${i}`); 
                partido.forEach((radio ,index) => {
                    console.log(radio.checked);
                    if(radio.checked){
                        resultado = radio.value;        
                    }
                });
                quinielaManual[i] = resultado;
            }
            let manualBet = {matches : []}; 
            Object.values(quinielaManual).forEach((result , match) =>{
                manualBet.matches[match] = result;
            })

            console.log(manualBet);
           tenBets.bets[10]= manualBet;
           renderBets();
           renderWinnerTicket(generateAutoWinnerTicket());
           calculateResults(ELEVEN_BETS);
           renderResults(); 
        })

      

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
                        <td>Apuesta${indexBet+1}</td>`; 
                        
                        bets.matches.forEach((match , indexMatch) =>{
                            if(match === 0 ){
                                renderBets += 
                                `<td> X </td>`
                            }else{
                                renderBets += 
                            `<td> ${match}</td>`
                            }
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
           let resultTable =  `<tr>
                                    <td>11 aciertos</td> <td> ${tableResults.once}</td>
                                </tr>
                                <tr>
                                    <td>12 aciertos</td> <td> ${tableResults.doce}</td>
                                </tr>
                                <tr>
                                    <td>13 aciertos</td> <td> ${tableResults.trece}</td>
                                </tr>
                                <tr>
                                    <td>14 aciertos</td> <td> ${tableResults.catorce}</td>
                                </tr>
                                <tr>
                                    <td>15 aciertos</td> <td> ${tableResults.quince}</td>
                                </tr>
                                <tr>
                                    <td>TOTAL GANADO</td> <td> ${tableResults.totalWinned}</td>
                                </tr>`

            results.innerHTML = resultTable;

        }

        const renderManualForm = ()=>{
            let i = 1 ; 
            let inputsManual = `<form type="submit" class=formManual>`
            for(i ; i <= 15 ; i++){
               inputsManual += `<fieldset>
                <legend>Partido ${i}</legend>
                    <input type="radio" name="partido${i}" value=1>1 
                    <input type="radio" name="partido${i}" value=0 checked>X 
                    <input type="radio" name="partido${i}" value=2>2 
                </fieldset>`
            }
            inputsManual += `<input type="submit" value="APOSTAR"> </form>`

            manualForm.innerHTML = inputsManual;
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
        



//CAMBIAR LOS 0 POR x 
