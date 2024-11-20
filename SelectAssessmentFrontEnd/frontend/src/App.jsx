import './App.css';
import InvoiceList from './components/invoice-list/InvoiceList';

function App() {
  return (
    <div className="App">
      <div className='header'>
        <h1 className="md:text-3xl mt-2 md:mb-5 xl:text-5xl xl:mb-10 lg:text-4xl lg:mb-8 text-white">
          Accounting Dashboard | Pending Invoices
        </h1>
        <hr className='mb-5' />

      </div>
      
      <InvoiceList />
    </div>
  );
}

export default App;
