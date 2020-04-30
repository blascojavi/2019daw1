import React, {Component} from 'react';
import TableComponent from "./TableComponent";
import InfectedChart from "./InfectedChart";
import DeathChart from "./DeathChart";

const COUNTRY_NODE = 13;

class Selector extends Component {
  selectorRef = React.createRef();

  state ={
    countriesList : [],
    countrySelected : false,
    selection : ""
  }

  change = (event)=>{
    this.setState({
      countrySelected : true,
      selection : event.target.value
    })
  }
  dataFromCountrySelected(){
   return this.props.data.filter(record => record.childNodes[COUNTRY_NODE].textContent === this.state.selection);

  }

  componentDidUpdate(nextProps: Readonly<P>, nextState: Readonly<S>, nextContext: any): void {
    this.dataFromCountrySelected()
  }
  render() {
      let countriesList = [];
      let renderTablesSection = "" ;
        countriesList.push(<option key={9000} value={"NO SELECTED"}>Seleccione un pais</option>)
      this.props.list.forEach((country , id)=>{
        countriesList.push(<option key={id} value={country}>{country}</option>)
      })
      if(this.state.countrySelected){
        renderTablesSection =
          <React.Fragment>
            <div className="table-container">
              <TableComponent
              selected = {this.state.selection}
              valueList = {this.dataFromCountrySelected()}/>
            </div>
            <div className="chart-container">
              <div className="chart-infected">
                <InfectedChart tableValues={this.dataFromCountrySelected()}/>
              </div>
              <div className="chart-deaths">
                <DeathChart tableValues={this.dataFromCountrySelected()}/>
              </div>
            </div>
          </React.Fragment>;
      }else{
        renderTablesSection = <h2 className="no-countrySelectedAdvise">Seleccione un pais</h2>
      }
           return(
             <div className="country-selector-container">
               <form>
                 <select onChange={this.change} ref={this.selectorRef} name="MainSelector">
                   {countriesList}
                 </select>
               </form>
                 {renderTablesSection}
            </div>
        );
    }
}

export default Selector;