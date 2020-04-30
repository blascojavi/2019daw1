import React, {Component} from 'react';
import {Bar} from 'react-chartjs-2';

const INFECTED_NODE = 9 ;
const DEATHS_NODE = 11;
const DATE_NODE = 1;

class InfectedChart extends Component{
  constructor(props){
    super(props);
    this.state = {
    }
  }
  componentDidMount(){
    this.constructDataSourceObject(this.props)
  }
  componentWillReceiveProps(newProps): void{
    this.constructDataSourceObject(newProps);
  }
  constructDataSourceObject(values) {
    let labels = []
    let deaths = []
    values.tableValues.forEach((val,key)=>{
      if(val.childNodes[INFECTED_NODE].textContent > 0 || val.childNodes[DEATHS_NODE].textContent > 0
        ||val.childNodes[DATE_NODE].textContent !== undefined ) {
        labels[key] = val.childNodes[DATE_NODE].textContent;
        deaths[key] = parseInt(val.childNodes[DEATHS_NODE].textContent);
      }
    })
    this.setState({
      chartData:{
        labels: labels,
        datasets:[
          {
            label:'Fallecidos',
            data:deaths,
            backgroundColor:[
              'rgba(255, 99, 132, 0.6)',
              'rgba(54, 162, 235, 0.6)',
              'rgba(255, 206, 86, 0.6)',
              'rgba(75, 192, 192, 0.6)',
              'rgba(153, 102, 255, 0.6)',
              'rgba(255, 159, 64, 0.6)',
              'rgba(255, 99, 132, 0.6)',
              'rgba(54, 162, 235, 0.6)',
              'rgba(255, 206, 86, 0.6)',
              'rgba(75, 192, 192, 0.6)',
              'rgba(153, 102, 255, 0.6)',
              'rgba(255, 159, 64, 0.6)',
              'rgba(54, 162, 235, 0.6)',
              'rgba(255, 206, 86, 0.6)',
              'rgba(75, 192, 192, 0.6)',
              'rgba(153, 102, 255, 0.6)',
              'rgba(255, 159, 64, 0.6)',
              'rgba(255, 99, 132, 0.6)',
              'rgba(54, 162, 235, 0.6)',
              'rgba(255, 206, 86, 0.6)',
              'rgba(75, 192, 192, 0.6)',
              'rgba(153, 102, 255, 0.6)',
              'rgba(255, 159, 64, 0.6)',
              'rgba(255, 99, 132, 0.6)'
            ]
          }
        ]
      }
    })
  }
  render(){
    return (
      <div className="chart">
        <h2>Fallecidos cada día</h2>
        <Bar
          data={this.state.chartData}
          options={{
            title:{
              display:this.props.displayTitle,
              text:'Largest Cities In '+this.props.location,
              fontSize:25
            },
            legend:{
              display:this.props.displayLegend,
              position:this.props.legendPosition
            }
          }}
        />
      </div>
    )
  }
}

export default InfectedChart;