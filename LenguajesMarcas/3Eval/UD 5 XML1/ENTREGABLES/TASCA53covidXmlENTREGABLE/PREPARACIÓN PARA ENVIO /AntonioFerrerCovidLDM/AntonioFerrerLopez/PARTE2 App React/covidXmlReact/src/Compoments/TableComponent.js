import React, {Component} from 'react';
import TableContent from "./TableContent";

class TableComponent extends Component {

  render() {
    return (
      <React.Fragment>
          <TableContent
            tableValues={this.props.valueList}
          />
      </React.Fragment>
    );
  }
}

export default TableComponent;