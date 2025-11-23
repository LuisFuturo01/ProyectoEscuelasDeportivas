const API_URL = 'http://localhost:8080/api';

let state = {
    escuelas: [],
    idxEscuela: 0,
    estudianteSelect: null
};

document.addEventListener('DOMContentLoaded', init);

async function init() {
    await recargarEscuelas();
}

// --- CONTROLADOR DE ESCUELAS (LDC_EscuelaDep) ---

async function recargarEscuelas() {
    try {
        // Simulamos datos si no hay API para que veas el diseño
        // const res = await fetch(`${API_URL}/escuelas`);
        // state.escuelas = await res.json();
        
        // --- DATOS DE PRUEBA PARA VISUALIZAR EL DISEÑO ---
        state.escuelas = [
            {
                idEsc: 1, nombre: "Escuela de Fútbol", responsable: "Carlos Bilardo", cupos: 30,
                listaEstudiantes: [
                    { idEst: 101, nombre: "Lionel", apellido: "Messi", telefono: "555-1010" },
                    { idEst: 102, nombre: "Diego", apellido: "Maradona", telefono: "555-2020" },
                    { idEst: 103, nombre: "Juan Román", apellido: "Riquelme", telefono: "555-3030" }
                ],
                colaEsperaIds: [201, 205, 209, 215]
            },
             {
                idEsc: 2, nombre: "Escuela de Basket", responsable: "Manu Ginóbili", cupos: 15,
                listaEstudiantes: [
                     { idEst: 301, nombre: "Michael", apellido: "Jordan", telefono: "555-2323" }
                ],
                colaEsperaIds: [305, 308]
            }
        ];
        // --------------------------------------------------

        if(state.escuelas.length > 0) {
             renderEscuelaActual();
        } else {
             document.getElementById('current-school-name').innerText = "Sin Escuelas";
        }

    } catch (e) { 
        console.error("Error API", e); 
        alert("Error conectando al backend. Se usaron datos de prueba si estaban habilitados en el código.");
    }
}

function navEscuela(dir) {
    if (state.escuelas.length === 0) return;
    if (dir === 'sig') state.idxEscuela = (state.idxEscuela + 1) % state.escuelas.length;
    else state.idxEscuela = (state.idxEscuela - 1 + state.escuelas.length) % state.escuelas.length;
    
    state.estudianteSelect = null; 
    renderPilaVisual(null);
    renderEscuelaActual();
}

function renderEscuelaActual() {
    if(state.escuelas.length === 0) return;
    const escuela = state.escuelas[state.idxEscuela];

    // 1. Sidebar Info
    document.getElementById('current-school-name').innerText = escuela.nombre;
    document.getElementById('school-metadata').innerHTML = `
        <p><span>ID Escuela:</span> <strong>${escuela.idEsc}</strong></p>
        <p><span>Responsable:</span> <strong>${escuela.responsable}</strong></p>
        <p><span>Inscritos:</span> <strong>${escuela.listaEstudiantes.length} / ${escuela.cupos}</strong></p>
    `;

    // 2. Renderizar LDC_Registro (Lista)
    const containerLDC = document.getElementById('container-ldc');
    containerLDC.innerHTML = escuela.listaEstudiantes.map(est => `
        <div class="node-card" onclick="seleccionarEstudiante(${est.idEst})">
            <h4>${est.nombre} ${est.apellido}</h4>
            <div class="node-meta">
                <span>ID: ${est.idEst}</span>
                <button onclick="abandonarEscuela(event, ${est.idEst})" class="btn-text icon-red" style="font-size:0.8rem">
                    <i class="fas fa-trash-alt"></i> Baja
                </button>
            </div>
        </div>
    `).join('') || '<p class="meta-placeholder">Lista vacía</p>';

    // 3. Renderizar CC_Espera (Cola)
    const containerCC = document.getElementById('container-cc');
    containerCC.innerHTML = escuela.colaEsperaIds.map(id => `
        <div class="queue-token" title="ID Estudiante">${id}</div>
    `).join('') || '<p class="meta-placeholder" style="margin: auto;">Cola vacía</p>';
}

// --- CONTROLADOR DE PILA (PM_Historial) ---

async function buscarEstudiante() {
    const idInput = document.getElementById('search-id');
    const id = idInput.value;
    if(!id) return idInput.focus();

    // --- DATOS DE PRUEBA PARA PILA ---
    // Simulación de respuesta del backend
    const mockEstudiante = { idEst: id, nombre: "Estudiante Simulado", apellido: "Prueba" };
    const mockHistorial = [
        { tipoMod: "INSCRIPCION", fecha: "2023-10-25 10:00" },
        { tipoMod: "CAMBIO_DISCIPLINA", fecha: "2023-11-05 14:30" },
         { tipoMod: "MANUAL_UPDATE", fecha: "2023-11-06 09:15" }
    ];
    // ----------------------------------

    try {
        // Descomentar para usar API real
        // const [resEst, resHist] = await Promise.all([
        //     fetch(`${API_URL}/estudiantes/${id}`),
        //     fetch(`${API_URL}/historial/${id}`)
        // ]);

        // if(resEst.ok) {
        //     state.estudianteSelect = await resEst.json();
        //     const historial = await resHist.json();
        //     renderPilaVisual(historial);
        // } else { alert("Estudiante no encontrado"); }

        // Usando mock para demostración visual:
        state.estudianteSelect = mockEstudiante;
        renderPilaVisual(mockHistorial);

    } catch(e) { alert("Error buscando datos"); }
}

async function seleccionarEstudiante(id) {
    document.getElementById('search-id').value = id;
    buscarEstudiante();
}

function renderPilaVisual(historial) {
    const container = document.getElementById('container-pm');
    const ownerName = document.getElementById('stack-owner-name');
    
    if (!state.estudianteSelect) {
        container.innerHTML = '<div class="empty-state">Busca un estudiante para ver su pila</div>';
        ownerName.innerText = '...';
        return;
    }

    ownerName.innerText = `${state.estudianteSelect.nombre} ${state.estudianteSelect.apellido}`;
    
    if(!historial || historial.length === 0) {
        container.innerHTML = '<div class="empty-state">Pila de historial vacía</div>';
        return;
    }

    // Renderizar LIFO (Last In First Out visualmente)
    container.innerHTML = historial.map(h => `
        <div class="stack-block">
            <span class="block-type">${h.tipoMod}</span>
            <span class="block-date">${h.fecha}</span>
        </div>
    `).join('');
}

// --- ACCIONES (STUBS PARA API) ---

async function desencolar() {
    alert("Llamada a API: POST /cola/atender/{idEsc}\n(Mueve el primero de la cola a la lista)");
    // Implementar fetch real aquí y llamar recargarEscuelas()
}

function encolarManual() {
    const id = prompt("Ingrese ID para encolar (Simulación):");
    if(id) alert(`Llamada a API: POST /cola/encolar con ID ${id}`);
     // Implementar fetch real aquí
}

async function pushHistorial() {
    if(!state.estudianteSelect) return alert("Selecciona un estudiante primero");
    alert(`Llamada a API: POST /historial/push para estudiante ${state.estudianteSelect.idEst}`);
}

async function popHistorial() {
    if(!state.estudianteSelect) return alert("Selecciona un estudiante");
    alert(`Llamada a API: DELETE /historial/pop/${state.estudianteSelect.idEst}`);
}

function modalInscribir() {
    mostrarModal('Nueva Inscripción', `
        <label style="font-weight:600; font-size:0.9rem;">Datos del Estudiante</label>
        <input id="i-nombre" placeholder="Nombre">
        <input id="i-apellido" placeholder="Apellido">
        <input id="i-tel" placeholder="Teléfono">
        <input type="date" id="i-fecha" placeholder="Fecha Nacimiento">
    `, async () => {
        alert("Llamada a API: POST /inscribir con los datos del formulario");
        // Implementar lógica real de fetch
        cerrarModal();
    });
}

async function abandonarEscuela(e, idEst) {
    e.stopPropagation();
    if(confirm(`¿Dar de baja al estudiante ID ${idEst}?`)) {
        alert(`Llamada a API: DELETE /abandonar/${idEst}`);
        // Implementar fetch real y recargar
    }
}

// --- UTILIDADES MODAL ---
function mostrarModal(titulo, htmlContent, onConfirm) {
    document.getElementById('modal-title').innerText = titulo;
    document.getElementById('modal-content').innerHTML = htmlContent;
    document.getElementById('modal').classList.remove('hidden');
    
    const btn = document.getElementById('modal-confirm-btn');
    const newBtn = btn.cloneNode(true);
    btn.parentNode.replaceChild(newBtn, btn);
    newBtn.onclick = onConfirm;
}

function cerrarModal() {
    document.getElementById('modal').classList.add('hidden');
}