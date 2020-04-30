import React, { Component } from 'react'
import './App.css';

import Header from "./Compoments/Header";
import Selector from "./Compoments/Selector";

const XML_PATH = "./Casos.xml";
const MAIN_TAG_NAME = "record";
const COUNTRY_NODE = 13 ;

let countriesList;
let dataArray;


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countriesList : [],
            data : []
        }
    }
    componentDidMount() {
        this.getDataFromSource().then(data=>{
            dataArray = this.parseHtmlCollectionToArray(data);
            countriesList = this.getCountriesList(dataArray)
            this.putCouniresListOnState(countriesList);
        })
    }
    async getDataFromSource() {
        return  fetch(XML_PATH)
            .then(response => {
                return response.text();
            })
            .then(dataString => {
                return  new window.DOMParser().parseFromString(dataString, "text/xml");
            });
    };
    parseHtmlCollectionToArray(data){
        return [].slice.call(data.getElementsByTagName(MAIN_TAG_NAME));
    }
    getCountriesList(dataArray){
        let countryList = new Set();
        dataArray.forEach(dataRegister=>{
            countryList.add(dataRegister.childNodes[COUNTRY_NODE].textContent);
        })
        return countryList;
    }
    putCouniresListOnState(){
        this.setState({
            countriesList : this.getCountriesList(dataArray) ,
            data : dataArray
        })
    }

    render() {
        let selectorComponent = <div></div>;
        if(this.state.countriesList !== [] ){
            selectorComponent =  <Selector
                list = {this.state.countriesList}
                data = {this.state.data}/>
        }else{
            selectorComponent = "Cargando componentes. Espere porfavor...";
        }

        return (
            <div className="App">
                <header className="App-header">
                    <Header/>
                </header>
                    <section className="countriesSelector-container">
                        {selectorComponent}
                    </section>
            </div>

        );
    }
}

export default App;