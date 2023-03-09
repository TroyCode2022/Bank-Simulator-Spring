import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/split-layout/src/vaadin-split-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/virtual-list/src/vaadin-virtual-list.js';

@customElement('home-view')
export class HomeView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-split-layout orientation="vertical" id="vaadinSplitLayout">
 <div id="div1" style="width: 100%; height: 100%;">
  <h2 style="padding: 10px;">Lista de Cuentas Bancarias y Tarjetas</h2>
  <vaadin-grid id="vaadinGrid" is-attached multi-sort-priority="prepend"></vaadin-grid>
 </div>
 <div id="div">
  <vaadin-virtual-list id="vaadinVirtualList"></vaadin-virtual-list>
 </div>
</vaadin-split-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
