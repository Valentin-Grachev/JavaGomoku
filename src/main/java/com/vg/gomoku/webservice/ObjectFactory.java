
package com.vg.gomoku.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vg.gomoku.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConnectAndGetPlayerNumber_QNAME = new QName("http://gomoku.vg.com/", "connectAndGetPlayerNumber");
    private final static QName _ConnectAndGetPlayerNumberResponse_QNAME = new QName("http://gomoku.vg.com/", "connectAndGetPlayerNumberResponse");
    private final static QName _GetCurrentModel_QNAME = new QName("http://gomoku.vg.com/", "getCurrentModel");
    private final static QName _GetCurrentModelResponse_QNAME = new QName("http://gomoku.vg.com/", "getCurrentModelResponse");
    private final static QName _MakeMove_QNAME = new QName("http://gomoku.vg.com/", "makeMove");
    private final static QName _MakeMoveResponse_QNAME = new QName("http://gomoku.vg.com/", "makeMoveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vg.gomoku.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConnectAndGetPlayerNumber }
     * 
     */
    public ConnectAndGetPlayerNumber createConnectAndGetPlayerNumber() {
        return new ConnectAndGetPlayerNumber();
    }

    /**
     * Create an instance of {@link ConnectAndGetPlayerNumberResponse }
     * 
     */
    public ConnectAndGetPlayerNumberResponse createConnectAndGetPlayerNumberResponse() {
        return new ConnectAndGetPlayerNumberResponse();
    }

    /**
     * Create an instance of {@link GetCurrentModel }
     * 
     */
    public GetCurrentModel createGetCurrentModel() {
        return new GetCurrentModel();
    }

    /**
     * Create an instance of {@link GetCurrentModelResponse }
     * 
     */
    public GetCurrentModelResponse createGetCurrentModelResponse() {
        return new GetCurrentModelResponse();
    }

    /**
     * Create an instance of {@link MakeMove }
     * 
     */
    public MakeMove createMakeMove() {
        return new MakeMove();
    }

    /**
     * Create an instance of {@link MakeMoveResponse }
     * 
     */
    public MakeMoveResponse createMakeMoveResponse() {
        return new MakeMoveResponse();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link ClientAction }
     * 
     */
    public ClientAction createClientAction() {
        return new ClientAction();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectAndGetPlayerNumber }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConnectAndGetPlayerNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "connectAndGetPlayerNumber")
    public JAXBElement<ConnectAndGetPlayerNumber> createConnectAndGetPlayerNumber(ConnectAndGetPlayerNumber value) {
        return new JAXBElement<ConnectAndGetPlayerNumber>(_ConnectAndGetPlayerNumber_QNAME, ConnectAndGetPlayerNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectAndGetPlayerNumberResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConnectAndGetPlayerNumberResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "connectAndGetPlayerNumberResponse")
    public JAXBElement<ConnectAndGetPlayerNumberResponse> createConnectAndGetPlayerNumberResponse(ConnectAndGetPlayerNumberResponse value) {
        return new JAXBElement<ConnectAndGetPlayerNumberResponse>(_ConnectAndGetPlayerNumberResponse_QNAME, ConnectAndGetPlayerNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentModel }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentModel }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "getCurrentModel")
    public JAXBElement<GetCurrentModel> createGetCurrentModel(GetCurrentModel value) {
        return new JAXBElement<GetCurrentModel>(_GetCurrentModel_QNAME, GetCurrentModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentModelResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentModelResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "getCurrentModelResponse")
    public JAXBElement<GetCurrentModelResponse> createGetCurrentModelResponse(GetCurrentModelResponse value) {
        return new JAXBElement<GetCurrentModelResponse>(_GetCurrentModelResponse_QNAME, GetCurrentModelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeMove }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MakeMove }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "makeMove")
    public JAXBElement<MakeMove> createMakeMove(MakeMove value) {
        return new JAXBElement<MakeMove>(_MakeMove_QNAME, MakeMove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeMoveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MakeMoveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gomoku.vg.com/", name = "makeMoveResponse")
    public JAXBElement<MakeMoveResponse> createMakeMoveResponse(MakeMoveResponse value) {
        return new JAXBElement<MakeMoveResponse>(_MakeMoveResponse_QNAME, MakeMoveResponse.class, null, value);
    }

}
