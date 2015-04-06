	<ul id="nav">
		<li class="top2"><a href="#" id="mantenedores" class="top_link"><span class="down">Mantenedores</span></a>
			<ul class="sub">
				<%if(usuario.getF3()==1){%><li><a href="/punto_control/productos.do">Productos</a></li><%} %>
				<%if(usuario.getF17()==1){%><li><a href="/punto_control/especies.do">Especies</a></li><%} %>
				<%if(usuario.getF18()==1){%><li><a href="/punto_control/transportistas.do">Proveedor</a></li><%} %>
				<%if(usuario.getF19()==1){%><li><a href="/punto_control/choferes.do">Choferes</a></li><%} %>
				<%if(usuario.getF5()==1){%><li><a href="/punto_control/camiones.do">Camiones</a></li><%} %>
				<%if(usuario.getF8()==1){%><li><a href="#" class="fly">Usuarios</a>
					<ul>
						<li>
							<a href="/punto_control/usuarios.do">Administrar</a>
						</li>
					</ul>
				</li><%} %>
				<%if(usuario.getF9()==1){%><li><a href="/punto_control/parametros.do">Parametros</a></li><%} %>
				<%if(usuario.getF11()==1){%><li><a href="#" class="fly">Mantencion BD</a>
					<ul>
						<li>
							<a href="/punto_control/puntocontrol/mantencion.do">Punto Control</a>
						</li>
					</ul>
				</li><%} %>
			</ul>
		</li>
		<li class="top2"><a href="#" id="punto_control" class="top_link"><span class="down">Punto Control</span></a>
			<ul class="sub">
				<%if(usuario.getF20()==1){%><li><a href="/punto_control/puntocontrol.do">Historial</a></li><%} %>
				<%if(usuario.getF4()==1){%><li><a href="/punto_control/puntocontrol/modificacion.do">Modificacion</a></li><%} %>
			</ul>
		</li>
		<li class="top2"><a href="/punto_control/salir.do" id="salir" class="top_link"><span>Salir</span></a>
		</li>
	</ul>