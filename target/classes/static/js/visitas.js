// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarVisitas();
  $('#visitas').DataTable();
});

async function cargarVisitas(){


  const request = await fetch('visitas', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const visitas = await request.json();


  let listadoHtml = '';
  for (let visita of visitas){
    let visitaHtml = '<tr><td>'+visita.identificacion+'</td><td>'+visita.apellidoU+'</td><td>'+visita.apellidoD+'</td><td>'+visita.nombre+'</td></tr>';

    listadoHtml += visitaHtml;
}

document.querySelector('#visitas tbody').outerHTML = listadoHtml;
}


