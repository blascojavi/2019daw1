export const TOTAL_MATCHS = 14; 
export const LOCAL_DICES = 5; 
export const TEN_BETS = 10; 
export const ELEVEN_BETS= 11 ; 

export const tableBody  = document.getElementById("tableBody");
export const ticketWinner  = document.getElementById("ticketWinner");
export const manualForm  = document.getElementById("manualForm");
export const results  = document.getElementById("results");
export const btnAutoPressed = document.getElementById("btnAuto"); 
export const btnManualPressed = document.getElementById("btnManual"); 


export const WIN_LOCAL = 0; 
export const TIE = 1; 
export const WIN_VISITOR = 2; 
export let tenBets = {
        bets: []
    }; 
export let hitsByBet = []; 
export let tableResults = {
        "once": 0, 
        "doce": 0,
        "trece": 0,
        "catorce": 0,
        "quince": 0,
        "totalWinned": 0
}

