import { useState, useEffect } from "react";
import axios from "axios";

export default function Enquiry(){

 const [form, setForm] = useState({
  name:"",
  email:"",
  phone:"",
  course:""
 });

 const [enquiries, setEnquiries] = useState([]);

 // Load enquiries from backend
 const loadEnquiries = async () => {
  const res = await axios.get(
   "http://localhost:8080/api/enquiries"
  );
  setEnquiries(res.data);
 };

 useEffect(() => {
  loadEnquiries();
 }, []);

 // Submit enquiry
 const submitEnquiry = async () => {

  if(!form.name || !form.email || !form.phone || !form.course){
   alert("Please fill all fields");
   return;
  }

  await axios.post(
   "http://localhost:8080/api/enquiries",
   form
  );

  alert("Enquiry saved successfully");

  setForm({
   name:"",
   email:"",
   phone:"",
   course:""
  });

  loadEnquiries();
 };

 return (
  <div style={{padding:"20px"}}>

   <h1>Course Enquiry Form</h1>

   <input
    placeholder="Name"
    value={form.name}
    onChange={e=>setForm({...form,name:e.target.value})}
   />
   <br/><br/>

   <input
    placeholder="Email"
    value={form.email}
    onChange={e=>setForm({...form,email:e.target.value})}
   />
   <br/><br/>

   <input
    placeholder="Phone"
    value={form.phone}
    onChange={e=>setForm({...form,phone:e.target.value})}
   />
   <br/><br/>

   <input
    placeholder="Course"
    value={form.course}
    onChange={e=>setForm({...form,course:e.target.value})}
   />
   <br/><br/>

   <button onClick={submitEnquiry}>
    Submit
   </button>

   <hr/>

   <h2>Submitted Enquiries</h2>

   {enquiries.map(e => (
    <div key={e.id}
     style={{
      border:"1px solid gray",
      padding:"10px",
      margin:"10px"
     }}>
      <p>Name: {e.name}</p>
      <p>Email: {e.email}</p>
      <p>Phone: {e.phone}</p>
      <p>Course: {e.course}</p>
    </div>
   ))}

  </div>
 );
}
