import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class UpdateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mobileName: '',
            color: '',
            price: '',

        }
        this.changeMobileNameHandler = this.changeMobileNameHandler.bind(this);
        this.changeColorHandler = this.changeColorHandler.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
            let employee = res.data;
            this.setState({
                mobileName: employee.mobileName,
                color: employee.color,
                price : employee.price,
            });
        });
    }

    updateEmployee = (e) => {
        e.preventDefault();
        let employee = {mobileName: this.state.mobileName, color: this.state.color, price: this.state.price};
        console.log('employee => ' + JSON.stringify(employee));
        console.log('id => ' + JSON.stringify(this.state.id));
        EmployeeService.updateEmployee(employee, this.state.id).then( res => {
            this.props.history.push('/employees');
        });
    }
    
    changeMobileNameHandler= (event) => {
        this.setState({mobileName: event.target.value});
    }

    changeColorHandler= (event) => {
        this.setState({color: event.target.value});
    }

    changePriceHandler= (event) => {
        this.setState({price: event.target.value});
    }

    cancel(){
        this.props.history.push('/employees');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3 cardshadow3">
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label>Mobile Name: </label>
                                            <input placeholder="Enter MobileName" name="MobileName" className="form-control" 
                                                value={this.state.mobileName} onChange={this.changeMobileNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Color: </label>
                                            <input placeholder="Enter Color" name="Color" className="form-control" 
                                                value={this.state.color} onChange={this.changeColorHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Price: </label>
                                            <input placeholder=" Enter Price" name="Price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateEmployeeComponent
