import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, IndexRoute, browserHistory} from 'react-router';
import App from './App';
import Home from './components/Home';
import About from './components/About';
import Faq from './components/Faq';
import Enroll from './components/Enroll';
import Klass from './components/Klass';

ReactDOM.render(
  <Router history={browserHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={Home} />
      <Route path="enroll" component={Enroll} />
      <Route path="klass" component={Klass} />
      <Route path="about" component={About} />
      <Route path="faq" component={Faq} />
    </Route>
  </Router>,
  document.getElementById('root')
);
