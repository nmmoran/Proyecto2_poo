/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyecto2_poo;

import com.pooespol.proyecto2_poo.data.*;
import com.pooespol.proyecto2_poo.data.MesaData;
import com.pooespol.proyecto2_poo.data.ProductosData;
import com.pooespol.proyecto2_poo.data.VentasData;
import com.pooespol.proyecto2_poo.modelo.Actualizable;
import com.pooespol.proyecto2_poo.modelo.ArchivosExceptions;
import com.pooespol.proyecto2_poo.modelo.Cuenta;
import com.pooespol.proyecto2_poo.modelo.Mesa;
import com.pooespol.proyecto2_poo.modelo.Mesero;
import com.pooespol.proyecto2_poo.modelo.Producto;
import com.pooespol.proyecto2_poo.modelo.Restaurante;
import com.pooespol.proyecto2_poo.modelo.Ubicacion;
import com.pooespol.proyecto2_poo.modelo.Venta;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class AdministradorController implements Initializable {

    @FXML
    private TextField txtFechaInicial;
    @FXML
    private TextField txtFechaFinal;
    @FXML
    private Button btBuscar;
    @FXML
    private FlowPane fpMuestraMenu;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtRuta;
    @FXML
    private ComboBox<String> cbOpTipo1;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnCancel1;
    @FXML
    private TextField txtNewPrecio;
    @FXML
    private TextField txtNewRuta;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnCancel2;
    @FXML
    private Label lbMessage;
    @FXML
    private Label lmessage2;
    @FXML
    private Button btnAceptar;
    private Button txtFiltoNombre;
    private TextField txtNewNa;
    static Restaurante r;
    @FXML
    private TextField txtFiltroNombre;
    @FXML
    private TextField txtNuevoNombre;
    @FXML
    private Button btnFiltro;
    @FXML
    private Pane pnMesas;
    @FXML
    private ScrollPane paneDeslizamiento;
    @FXML
    private Tab pestañaMonitoreo;
    @FXML
    private Pane pnMonitoreo;
    
    private int x;
    private int y;

    @FXML
    private TableColumn<ReporteVentasData, String> tableFecha;
    @FXML
    private TableColumn<ReporteVentasData, Integer> tableMesa;
    @FXML
    private TableColumn<ReporteVentasData, String> tableMesero;
    @FXML
    private TableColumn<ReporteVentasData, Integer> tableCuenta;
    @FXML
    private TableColumn<ReporteVentasData, String> tableCliente;
    @FXML
    private TableColumn<ReporteVentasData, Double> tableTotal;
    @FXML
    private TableView<ReporteVentasData> TableView;

    private ObservableList<ReporteVentasData> ventasVisibles = FXCollections.observableArrayList();
    @FXML
    private HBox HboxCont;
    @FXML
    private Label lblTF;
    @FXML
    private Label lblNC;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarMesasMonitor(pnMonitoreo);
        inicializarDiseñoPlano(pnMesas);
        tableFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableMesa.setCellValueFactory(new PropertyValueFactory<>("numeroMesa"));
        tableMesero.setCellValueFactory(new PropertyValueFactory<>("mesero"));
        tableCuenta.setCellValueFactory(new PropertyValueFactory<>("numeroCuenta"));
        tableCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tableTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        try {
            r = new Restaurante();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ArrayList<String> tipos = ProductosData.obtenerTipos();
        cbOpTipo1.setItems(FXCollections.observableArrayList(tipos));
        txtPrecio.clear();
        txtName.setDisable(true);
        txtPrecio.setDisable(true);
        txtRuta.setDisable(true);
        btnAceptar.setDisable(true);
        try {
            Restaurante r = new Restaurante();
            //obtengo la lista de productos d
            List<Producto> listp = r.getListproductos();
            for (Producto p : listp) {
                VBox vboxproducto = new VBox();
                //crear la imagen
                try {
                    InputStream inputImg = App.class.getResource(p.getImagen()).openStream();
                    ImageView imgv = new ImageView(new Image(inputImg));
                    vboxproducto.getChildren().add(imgv);
                } catch (Exception ex) {
                    
                    ex.printStackTrace();
                }
                
                //crea el label del nombre y lo agrego al VBox
                Label lnombre = new Label(p.getNombre());
                vboxproducto.getChildren().add(lnombre);
                //el anio de la pelicula
                Label lprecio = new Label(String.valueOf(p.getPrecio()));
                vboxproducto.getChildren().add(lprecio);
                
                vboxproducto.setPadding(new Insets(2, 3, 3, 4));
                
                //agregamos el VBox al FlowPane
                fpMuestraMenu.getChildren().add(vboxproducto);
                
            }
            Actualizable a1 = new Actualizable(lblTF,lblNC);
            Thread t = new Thread(a1);
            t.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Label getLblTF() {
        return lblTF;
    }

    public void setLblTF(Label lblTF) {
        this.lblTF = lblTF;
    }

    public Label getLblNC() {
        return lblNC;
    }

    public void setLblNC(Label lblNC) {
        this.lblNC = lblNC;
    }

    @FXML

    private void buscarFechas(MouseEvent event) throws IOException {

        ventasVisibles.clear();
        ArrayList<Venta> ventasArreglo = VentasData.leerVentas();
        String fi, ff;

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fi = txtFechaInicial.getText().replace('-', '/');
        ff = txtFechaFinal.getText().replace('-', '/');
        LocalDate fechai = LocalDate.parse(fi, form);
        LocalDate fechaf = LocalDate.parse(ff, form);

        String f1[] = fi.split("-");
        String f2[] = ff.split("-"); //fecha final
        try {
            for (Venta v : ventasArreglo) {
                String fecha = v.getFecha().replace('-', '/'); //dd-mm-aa
                LocalDate fechatxt = LocalDate.parse(fecha, form);

                if ((fechatxt.isBefore(fechaf) || (fechatxt.isEqual(fechaf)))
                        && ((fechatxt.isAfter(fechai)) || (fechatxt.isEqual(fechai)))) {

                    int numeroMesa = v.getDatosCuenta().getMesa().getNumero();
                    String nombre = v.getMesero().getNombre();
                    int numeroCuenta = v.getDatosCuenta().getNumCuenta();
                    String cliente = v.getDatosCuenta().getCliente();
                    double total = v.getTotal();

                    ReporteVentasData rv = new ReporteVentasData(fecha,
                            numeroMesa, nombre, numeroCuenta, cliente, total);

                    ventasVisibles.add(rv);
                }

                System.out.println(v.getFecha() + " " + v.getDatosCuenta().getMesa().getNumero()
                        + " " + v.getMesero().getNombre() + " " + v.getDatosCuenta().getNumCuenta() + " " + v.getDatosCuenta().getCliente() + " " + v.getTotal());
            }
            TableView.setItems(ventasVisibles);

        } catch (DateTimeParseException dx) {
            Label mensaje = new Label("Ingrese la fecha en el formato correspontiende dd/mm/aa");
            HboxCont.getChildren().add(mensaje);
            //dx.getMessage();
        } catch (Exception ex) {
            //ex.getMessage();
        }

    }

    @FXML
    private void añadirNuevoProducto(MouseEvent event) throws ArchivosExceptions {
        try {

            String tipo = cbOpTipo1.getValue();
            String nombre = txtName.getText();
            double precio = Double.valueOf(txtPrecio.getText());
            String imagen = txtRuta.getText();
            if (tipo == null && imagen == null && nombre == null) {
                throw new NullPointerException("No puede haber campos vacios");
            }

            Producto p = new Producto(nombre, precio, imagen, tipo);

            //registrar producto
            r.registrarProducto(nombre, precio, imagen, tipo);
            ProductosData.escribirProducto(p);

            txtName.clear();
            txtPrecio.clear();
            txtRuta.clear();
            lbMessage.setText("El producto se registro");
            txtName.setDisable(true);
            txtPrecio.setDisable(true);
            txtRuta.setDisable(true);

        } catch (NullPointerException ex) {
            lbMessage.setText("No puede haber campos vacios");
        } catch (NumberFormatException ex) {
            lmessage2.setText("valor no valido precio");
        }
        //maneja las excepciones de tipo IOException y URISyntaxException
        //de la misma manera

    }
//nico

    @FXML
    private void limpiarFields(MouseEvent event) {

        txtName.clear();
        txtPrecio.clear();
        txtRuta.clear();
        txtName.setDisable(true);
        txtPrecio.setDisable(true);
        txtRuta.setDisable(true);
        btnAceptar.setDisable(true);
        lbMessage.setText("");
    }

    @FXML
    private void modificarProducto(MouseEvent event) throws IOException, ArchivosExceptions {
        String nom = txtFiltroNombre.getText();
        String newNombre = txtNuevoNombre.getText();
        String newPrecio = txtNewPrecio.getText();
        String newRuta = txtNewRuta.getText();

        ArrayList<Producto> productos = r.getListproductos();
        for (Producto p : productos) {
            if (p.getNombre().equals(nom)) {
                p.setNombre(newNombre);
                p.setPrecio(Double.parseDouble(newPrecio));
                p.setImagen(newRuta);
                ProductosData.borrarArchivo();
                ProductosData.sobreescribirProducto(productos);
            }
        }

    }

    @FXML
    private void habilitarText(MouseEvent event) {
        txtName.setDisable(false);
        txtPrecio.setDisable(false);
        txtRuta.setDisable(false);
        btnAceptar.setDisable(false);
        lbMessage.setText("");
    }

    @FXML
    private void filtrarProductos(MouseEvent event) {
        try {
            String name = txtFiltroNombre.getText();
            for (Producto p : r.getListproductos()) {

                if ((p.getNombre().equals(name)) == true) {

                    txtNuevoNombre.setText(p.getNombre());
                    txtNewPrecio.setText(String.valueOf(p.getPrecio()));
                    txtNewRuta.setText(p.getImagen());

                }

            }

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }

    @FXML
    private void salir(Event event) {
        App.setRoot("login");
    }

    private void inicializarMesasMonitor(Pane pane) {

        try {
            ArrayList<Mesa> mesas = MesaData.leerMesas();
            for (Mesa mesa : mesas) {
                
                if (mesa.getCapacidad() == 4) {
                    
                    Circle c = new Circle(40, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(100);
                    contenedor.setPrefWidth(100);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                
                                cargarDatosMesas(mesa);
                            }
                    );
                    
                } else if (mesa.getCapacidad() == 6) {
                    Circle c = new Circle(60, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(140);
                    contenedor.setPrefWidth(140);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                
                                cargarDatosMesas(mesa);
                            }
                    );
                    
                } else if (mesa.getCapacidad() == 8) {
                    Circle c = new Circle(80, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(180);
                    contenedor.setPrefWidth(180);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                
                                cargarDatosMesas(mesa);
                            }
                    );
                } else if (mesa.getCapacidad() == 9) {
                    Circle c = new Circle(90, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(200);
                    contenedor.setPrefWidth(200);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                
                                cargarDatosMesas(mesa);
                            }
                    );
                } else if (mesa.getCapacidad() == 2) {
                    Circle c = new Circle(20, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(85);
                    contenedor.setPrefWidth(85);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                
                                cargarDatosMesas(mesa);
                            }
                    );
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarDatosMesas(Mesa mesa) {
        try {
            //limpiamos el contenido anterior

            FXMLLoader loader = new FXMLLoader(getClass().getResource("infoMesa.fxml"));
            Parent root = loader.load();
            InfoMesaController controlador = loader.getController();

            if ((mesa.getCuenta() != null)) {
                Mesero mesero = mesa.getCuenta().getMesero();
                String txtNm = new String(controlador.getLblMesa().getText());
                controlador.getLblMesa().setText(txtNm + mesa.getNumero());
                String txtCap = new String(controlador.getLblCapacidad().getText());
                controlador.getLblCapacidad().setText(txtCap + mesa.getCapacidad());
                String txtLm = new String(controlador.getLblMesero().getText());
                controlador.getLblMesero().setText(txtLm + mesero.getNombre());
                Scene sc = new Scene(root);
                Stage st = new Stage();
                st.initModality(Modality.APPLICATION_MODAL);
                st.setScene(sc);
                st.show();
                //Se crea un String del texto ya existente en el Label para que asi se añada el texto correspondiente
                //Luego a los atributos del controlador se les añade el string y wala!

            } else {
                String txtNm = new String(controlador.getLblMesa().getText());
                controlador.getLblMesa().setText(txtNm + mesa.getNumero());
                String txtCap = new String(controlador.getLblCapacidad().getText());
                controlador.getLblCapacidad().setText(txtCap + mesa.getCapacidad());
                controlador.getLblMesero().setText("Sin mesero");
                Scene sc = new Scene(root);
                Stage st = new Stage();
                st.initModality(Modality.APPLICATION_MODAL);
                st.setScene(sc);
                st.show();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void inicializarDiseñoPlano(Pane pane) {

        try {
            ArrayList<Mesa> mesas = MesaData.leerMesas();
            pane.setOnMouseClicked(
                    (MouseEvent ev) -> {
                        //para que no se propague
                        ev.consume();
                        double x = ev.getX();
                        double y = ev.getY();
                        crearMesas(x, y, pane);
                    }
            );
            for (Mesa mesa : mesas) {
                
                if (mesa.getCapacidad() == 4) {
                    
                    Circle c = new Circle(40, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(100);
                    contenedor.setPrefWidth(100);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseDragged(event -> {
                        try {
                            double deltaX = event.getSceneX();
                            double deltaY = event.getSceneY();
                            contenedor.setLayoutX(deltaX);
                            contenedor.setLayoutY(deltaY);
                            Ubicacion ub = new Ubicacion(deltaX, deltaY);
                            mesa.setUbicacion(ub);
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(AdministradorController.r.getListMesas());
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    });
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                opciones(mesa);
                            }
                    );
                    
                } else if (mesa.getCapacidad() == 6) {
                    Circle c = new Circle(60, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(140);
                    contenedor.setPrefWidth(140);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseDragged(event -> {
                        try {
                            double deltaX = event.getSceneX();
                            double deltaY = event.getSceneY();
                            contenedor.setLayoutX(deltaX);
                            contenedor.setLayoutY(deltaY);
                            Ubicacion ub = new Ubicacion(deltaX, deltaY);
                            mesa.setUbicacion(ub);
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(AdministradorController.r.getListMesas());
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    });
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                opciones(mesa);
                            }
                    );
                    
                } else if (mesa.getCapacidad() == 8) {
                    Circle c = new Circle(80, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(180);
                    contenedor.setPrefWidth(180);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseDragged(event -> {
                        try {
                            double deltaX = event.getSceneX();
                            double deltaY = event.getSceneY();
                            contenedor.setLayoutX(deltaX);
                            contenedor.setLayoutY(deltaY);
                            Ubicacion ub = new Ubicacion(deltaX, deltaY);
                            mesa.setUbicacion(ub);
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(AdministradorController.r.getListMesas());
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    });
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                opciones(mesa);
                            }
                    );
                } else if (mesa.getCapacidad() == 9) {
                    Circle c = new Circle(90, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(200);
                    contenedor.setPrefWidth(200);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseDragged(event -> {
                        try {
                            double deltaX = event.getSceneX();
                            double deltaY = event.getSceneY();
                            contenedor.setLayoutX(deltaX);
                            contenedor.setLayoutY(deltaY);
                            Ubicacion ub = new Ubicacion(deltaX, deltaY);
                            mesa.setUbicacion(ub);
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(AdministradorController.r.getListMesas());
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    });
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                opciones(mesa);
                            }
                    );
                } else if (mesa.getCapacidad() == 2) {
                    Circle c = new Circle(20, Color.rgb(255, 220, 31));
                    Label l = new Label("M" + String.valueOf(mesa.getNumero()));
                    StackPane contenedor = new StackPane();
                    contenedor.setPrefHeight(85);
                    contenedor.setPrefWidth(85);
                    contenedor.getChildren().addAll(c, l);
                    contenedor.setLayoutX(mesa.getUbicacion().getCoordenadaX());
                    contenedor.setLayoutY(mesa.getUbicacion().getCoordenadaY());
                    pane.getChildren().add(contenedor);
                    contenedor.setOnMouseDragged(event -> {
                        try {
                            double deltaX = event.getSceneX();
                            double deltaY = event.getSceneY();
                            contenedor.setLayoutX(deltaX);
                            contenedor.setLayoutY(deltaY);
                            Ubicacion ub = new Ubicacion(deltaX, deltaY);
                            mesa.setUbicacion(ub);
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(AdministradorController.r.getListMesas());
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    });
                    contenedor.setOnMouseClicked(
                            (MouseEvent ev) -> {
                                //para que no se propague
                                ev.consume();
                                opciones(mesa);
                            }
                    );
                }
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void crearMesas(double x, double y, Pane pane) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("crearMesas.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();
            CrearMesasController controlador = loader.getController();
            controlador.setMesaUbi(new Ubicacion(x, y));
            controlador.setPane(pane);
        } catch (IOException e) {
        }
    }

    private void opciones(Mesa mesa) {
        try {
            //limpiamos el contenido anterior

            FXMLLoader loader = new FXMLLoader(getClass().getResource("opciones.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();
            OpcionesController con = loader.getController();
            con.setMesa(mesa);
            con.getBtnModificarM().setOnMouseClicked(
                    (MouseEvent ev) -> {
                        ev.consume();
                        modificarMesa(mesa);
                        con.cerrarVentanaEliminar(ev);
                    }
            );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void modificarMesa(Mesa mesa) {
        try {
            //limpiamos el contenido anterior

            FXMLLoader loader = new FXMLLoader(getClass().getResource("modificarBorrarMesas.fxml"));
            Parent root = loader.load();
            ModificarBorrarMesasController con = loader.getController();

            con.getLbNumMesa().setText(String.valueOf(mesa.getNumero()));
            con.getTxtInfoCap().setText(String.valueOf(mesa.getCapacidad()));
            Scene sc = new Scene(root);
            Stage st = new Stage();
            st.initModality(Modality.APPLICATION_MODAL);
            st.setScene(sc);
            st.show();

            con.getBtmModificarMesa().setOnMouseClicked(
                    (MouseEvent ev) -> {
                        //para que no se propague
                        ev.consume();

                        try {
                            int ca = Integer.parseInt(con.getTxtInfoCap().getText());

                            for (Mesa m : r.getListMesas()) {
                                if (m.getNumero() == (mesa.getNumero())) {
                                    m.setCapacidad(ca);
                                    mesa.setCapacidad(ca);
                                }
                            }
                            /*con.getLbNumMesa().setText(String.valueOf(mesa.getNumero()));
                            con.getTxtInfoCap().setText(String.valueOf(mesa.getCapacidad()));*/
                            MesaData.borrarArchivoMesas();
                            MesaData.sobreescribirMesa(r.getListMesas());
                            con.cerrarVentanaModificar(ev);
                        } catch (ArchivosExceptions ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
            );

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
