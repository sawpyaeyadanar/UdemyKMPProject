//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Saw Pyae Yadanar on 20/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared
import SwiftUI

extension SourcesScreen {
  
  @MainActor
  class SourcesViewModelWrapper: ObservableObject {
    
    let sourcesViewModel: SourcesViewModel
    @Published var sourcesState: SourcesState
    
    init() {
      self.sourcesViewModel = SourcesInjector().sourcesViewModel
      self.sourcesState = self.sourcesViewModel.sourcesState.value
    }
    
    func startObserving() {
      Task {
        for await sources in sourcesViewModel.sourcesState {
          self.sourcesState = sources
        }
      }
    }
  }
}

struct SourcesScreen: View {
  @Environment(\.dismiss) private var dismiss
  @ObservedObject private(set) var viewModel: SourcesViewModelWrapper
  
  var body: some View {
    NavigationStack {
      VStack {
        
        if viewModel.sourcesState.loading {
          Loader()
        }
        
        if let error = viewModel.sourcesState.error {
          ErrorMessage(message: error)
        }
        
        if (!viewModel.sourcesState.sources.isEmpty) {
          ScrollView {
            LazyVStack(spacing: 10) {
              ForEach(viewModel.sourcesState.sources, id: \.self) { source in
                SourceItemView(source: source)
              }
            }
          }
        }
      }
      .onAppear(perform: {
        self.viewModel.startObserving()
      })
      .navigationTitle("Sources")
      .toolbar(content: {
        ToolbarItem(placement: .primaryAction) {
          Button {
            dismiss()
          } label: {
            Text("Done")
              .bold()
          }
        }
      })
    }
  }
}

struct SourceItemView: View {
  var source: Source
  var body: some View {
    VStack {
      Text(source.name)
        .font(.title)
        .fontWeight(.bold)
      Text(source.desc)
      Text(source.origin)
        .frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
    }
    .padding(16)
  }
}
struct SourceAppBar: View {
  var body: some View {
    Text("Sources")
      .font(.largeTitle)
      .fontWeight(.bold)
  }
}

