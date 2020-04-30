import React, {Component} from 'react';
import Chip from '@material-ui/core/Chip';
import InfectedIcon from '@material-ui/icons/BugReport';
import DeathIcon from '@material-ui/icons/AirlineSeatIndividualSuite';
import DoneIcon from '@material-ui/icons/Done';

const INFECTED_NODE = 9 ;
const DEATHS_NODE = 11;
const DATE_NODE = 1;

class TableContent extends Component {
  rowRef = React.createRef();
  dateCell = React.createRef();
  infCell = React.createRef();
  deathCell = React.createRef();

  state = {
    infected : 0,
    deaths : 0,
    dataRows: []
  }

  componentDidMount(): void {
    this.recreatingTableBody(this.props.tableValues);
  }
  componentWillReceiveProps(newProps): void {
    this.recreatingTableBody(newProps.tableValues)
  }

  recreatingTableBody(newProps){
    let rows = [];
    let totalInfected = 0;
    let totalDeaths = 0 ;
      newProps.forEach((val,key)=>{
        totalInfected += parseInt(val.childNodes[INFECTED_NODE].textContent);
        totalDeaths += parseInt(val.childNodes[DEATHS_NODE].textContent);
        if(val.childNodes[INFECTED_NODE].textContent > 0 || val.childNodes[DEATHS_NODE].textContent > 0 ){
         rows[key]= this.createData(val.childNodes[DATE_NODE].textContent,
                                val.childNodes[INFECTED_NODE].textContent,
                                val.childNodes[DEATHS_NODE].textContent,
                               )
        }
      })
    this.setState({
        infected : totalInfected,
          deaths : totalDeaths,
        dataRows : rows
    })
  }
  createData(dateReg: string, infectedDay: number, deathsDay: number) {
    return { dateReg , infectedDay, deathsDay };
  }
  render() {
    return (
      <React.Fragment>
        <table className="data-table">
          <thead className="data-table-head">
          <tr>
            <td>FECHA</td>
            <td>INFECTADOS</td>
            <td>FALLECIDOS</td>
          </tr>
          </thead>
          <tbody className="data-table-body">
        {this.state.dataRows.map((row,id) => (
          <tr key={(id*67)} ref={this.rowRef}>
            <td ref={this.dateCell} key={(id*100)} align="center">{row.dateReg}</td>
            <td ref={this.infCell} key={(id*200)} align="center">{row.infectedDay}</td>
            <td ref={this.deathCell} key={(id*300)} align="center">{row.deathsDay}</td>
          </tr>
        ))}
      </tbody>
  </table>
        <div className="chips">
          <div className="chip-infected">
            <Chip
              icon={<InfectedIcon />}
              label={`INFECCIONES TOTALES : ${this.state.infected} `}
              clickable
              color="primary"
              deleteIcon={<DoneIcon />}
            />
          </div>
          <div className="chip-deaths">
            <Chip
              icon={<DeathIcon />}
              label={`FALLECIMIENTOS TOTALES : ${this.state.deaths} `}
              clickable
              color="secondary"
              deleteIcon={<DoneIcon />}
            />
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default TableContent;


