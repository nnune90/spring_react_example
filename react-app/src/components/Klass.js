import React from 'react';
import axios from 'axios';

export default class Klass extends React.Component{
  constructor(props){
    super(props);
    this.state = {students: []};
    this.get = this.get.bind(this);
  }

  get(e){
    e.preventDefault();
    const id = +this.kid.value;
    const url = `http://localhost:9000/klasses/${id}`;
    axios.get(url).then(r => {
      this.setState({students: r.data});
    }).catch(e => {
      this.setState({students: []});
    });
  }

  render(){
    return (
      <div>
        <h1>Klassroom Query</h1>
        <div className="row">
          <div className="col-xs-4">

            <form>
              <div className="form-group">
                <label>Klass Id</label>
                <input ref={n => this.kid = n} type="number" className="form-control" />
              </div>
              <div className="form-group">
                <button onClick={this.get} className="btn btn-success">Get Students</button>
              </div>
            </form>

            <h3>Students</h3>
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
                {
                  this.state.students.map(s => {
                    return <tr key={s.id}><td>{s.email}</td></tr>;
                  })
                }
              </tbody>
            </table>

          </div>
          <div className="col-xs-8">
          </div>
        </div>
      </div>
    );
  }
}
