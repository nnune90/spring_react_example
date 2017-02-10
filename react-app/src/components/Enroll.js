import React from 'react';
import axios from 'axios';
import { browserHistory } from 'react-router';

export default class Enroll extends React.Component{
  constructor(props){
    super(props);
    this.state = {};
    this.create = this.create.bind(this);
  }

  create(){
    const emails = this.emails.value.split(',');
    const [teacher, age, gender] = this.teacher.value.split(',');
    const [klass, semester, credits, department, fee] = this.klass.value.split(',');
    const payload = {
      emails,
      teacher: {
        name: teacher,
        age,
        gender
      },
      klass: {
        name: klass,
        semester,
        credits,
        department,
        fee
      }
    };
    const url = 'http://localhost:9001/registration/enroll';
    axios.post(url, payload).then(r => {
      browserHistory.push('/klass');
    }).catch(e => {
    });
  }

  render(){
    return (
      <div>
        <h1>Classroom Creator</h1>
        <div>
          <label>Emails</label>
          <input ref={n => this.emails = n} type="text" />
        </div>
        <div>
          <label>Teacher</label>
          <input ref={n => this.teacher = n} type="text" />
        </div>
        <div>
          <label>Klass</label>
          <input ref={n => this.klass = n} type="text" />
        </div>
        <div>
          <button onClick={this.create}>Create Classroom</button>
        </div>
      </div>
    );
  }
}
