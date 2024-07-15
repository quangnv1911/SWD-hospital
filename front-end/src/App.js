
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { publicRoutes } from './routes';
import SideBar from './components/SideBar';
import Footer from './components/Footer';
import TopBar from './components/TopBar';

function App() {
  return (

    <div id="wrapper" className=''>
     
      <div id="content-wrapper" class="
      
      d-flex flex-column">
    
        <div id="content">
        <TopBar/>

          <div class="container-fluid">
            <Router >
              <Routes>
                {publicRoutes.map((route, index) => {
                  const Page = route.component;
                  return <Route key={index} path={route.path} element={<Page />} />
                })}
              </Routes>
            </Router>
          </div>
        </div>
        <Footer />
      </div>
    </div>


  );
}

export default App;
